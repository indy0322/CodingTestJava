package Hash;

public class OpenHash<K,V> {
    enum Status {OCCUPIED,EMPTY,DELETED}; //OCCUPIED: 데이터 저장 상태, EMPTY: 비어 있음, DELETED: 현재 버킷은 삭제되었지만, 다른 버킷에 같은 해시값을 갖는 요소가 있음.
    
    static class Bucket<K,V>{
        private K key;
        private V data;
        private Status stat;

        Bucket(){
            stat = Status.EMPTY; //버킷이 비어있음.
        }

        void set(K key, V data, Status stat){//모든 필드값 설정
            this.key = key;
            this.data = data;
            this.stat = stat;
        }

        void setStat(Status stat){//버킷 상태 설정
            this.stat = stat;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return data;
        }

        public int hashCode(){
            return key.hashCode();
        }
    }

    private int size;
    private Bucket<K,V>[] table;

    public OpenHash(int size){
        try{
            table = new Bucket[size];
            for(int i = 0;i < size;i++){
                table[i] = new Bucket<>();
            }
            this.size = size;
        }catch(OutOfMemoryError e){
            this.size = 0;
        }
    }

    public int hashValue(Object key){
        return key.hashCode() % size;
    }

    public int rehashValue(int hash){
        return (hash + 1) % size;
    }

    private Bucket<K,V> searchNode(K key){//키값이 key인 버킷을 검색
        int hash = hashValue(key);
        Bucket<K,V> p = table[hash];

        for(int i = 0;p.stat != Status.EMPTY && i < size;i++){
            if(p.stat == Status.OCCUPIED && p.getKey().equals(key))
                return p;
            hash = rehashValue(hash);
            p = table[hash];
        }
        return null;
    }

    public V search(K key){//키값이 key인 요소를 겁색(데이터를 반환)
        Bucket<K,V> p = searchNode(key);
        if(p != null)
            return p.getValue();
        else   
            return null;
    }

    public int add(K key, V data){
        if(search(key) != null)
            return 1; //이 키값은 이미 등록됨.
        
        int hash = hashValue(key);
        Bucket<K,V> p = table[hash];
        for(int i=0;i < size;i++){
            if(p.stat == Status.EMPTY || p.stat == Status.DELETED){
                p.set(key,data,Status.OCCUPIED);
                return 0; //삽입됨.
            }
            hash = rehashValue(hash);
            p = table[hash];
        }
        return 2; // 해시 테이블이 가득 참.
    }

    public int remove(K key){
        Bucket<K,V> p = searchNode(key); //선택한 버킷
        if(p == null)
            return 1; //이 키값은 등록되지 않음.

        p.setStat(Status.DELETED);
        return 0;
    }

    public void dump(){
        for(int i=0;i < size;i++){
            System.out.printf("%02d ",i);
            switch(table[i].stat){
                case OCCUPIED:
                    System.out.printf("%s (%s)\n",table[i].getKey(),table[i].getValue());
                    break;
                
                case EMPTY:
                    System.out.println("-- 비어 있음 --");
                    break;

                case DELETED:
                    System.out.println("-- 삭제 마침 --");
                    break;
            }
        }
    }
}
