package Hash;

public class ChainHash<K,V> {
    class Node<K,V>{
        private K key;
        private V data;
        private Node<K,V> next; 

        Node(K key, V data, Node<K,V> next){
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return data;
        }

        public int hashCode(){
            return key.hashCode();// 자바에서 모든 클래스는 기본적으로 Object를 상속받는다. 따라서 제네릭 타입 <K>도 실제로는 Object 타입 이상이다.(Object 객체 안에 hashCode() 메서드가 존재한다.)
        }
    }

    private int size; //해시 테이블 용량
    private Node<K,V>[] table;//해시테이블을 저장하는 배열

    public ChainHash(int capacity){
        try{
            table = new Node[capacity];
            this.size = capacity;
        }catch (OutOfMemoryError e){
            this.size = 0;
        }
    }

    public int hashValue(Object key){//해시 테이블의 인덱스를 계산하는 역할을 한다.
        return key.hashCode() % size;
    }

    public V search(K key){
        int hash = hashValue(key); //검색할 데이터의 해시값
        Node<K,V> p = table[hash]; //선택 노드

        while(p != null){
            if(p.getKey().equals(key)){
                return p.getValue(); //검색 성공
            }
            p = p.next; //다음 노드를 선택
        }
        return null; //검색 실패
    }

    public int add(K key, V data){
        int hash = hashValue(key);
        Node<K,V> p = table[hash];

        while(p != null){
            if(p.getKey().equals(key)){ //이 키값은 이미 등록됨.
                return 1;
            }
            p = p.next;
        }
        Node<K,V> temp =new Node<K,V>(key,data,table[hash]);//table[hash]는 현재 table의 hash 인덱스에 이미 들어있는 값을 의미한다.
        table[hash] = temp; //노드를 table의 hash 인덱스에 삽입하고 기존에 있던 값들은 삽입된 노드의 next가 된다.
        return 0;
    }

    public int remove(K key){
        int hash = hashValue(key); //삭제할 데이터의 해시값
        Node<K,V> p = table[hash]; //선택 노드
        Node<K,V> pp = null; //선택 노드의 이전 노드

        while(p != null){
            if(p.getKey().equals(key)){
                if(pp == null){
                    table[hash] = p.next;
                }else{
                    pp.next = p.next;
                }
            }
            pp = p;
            p = p.next;
        }
        return 1; //삭제할 키값이 없다.
    }

    public void dump(){
        for(int i = 0;i < size;i++){
            Node<K,V> p = table[i];
            System.out.printf("%02d ",i);
            while(p != null){
                System.out.printf("-> %s (%s) ",p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }
}
