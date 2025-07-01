package Tree;

import java.util.Comparator;

public class Binary_Tree<K,V> {
    static class Node<K,V>{
        private K key; //키값
        private V data; //데이터
        private Node<K,V> left; //왼쪽 포인터(왼쪽 자식 노드에 대한 참조)
        private Node<K,V> right; //오른쪽 포인터(오른쪽 자식 노드에 대한 참조)

        Node(K key, V data, Node<K,V> left, Node<K,V> right){
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey(){ //키값을 반환
            return key;
        }

        V getValue(){ //데이터 반환
            return data;
        }

        void print(){ //데이터 출력
            System.out.println(data);
        }
    }

    private Node<K,V> root; //루트에 대한 참조 필드
    private Comparator<? super K> comparator = null; // 키값의 대소 관계를 비교하는 비교자

    public Binary_Tree(){
        root = null;
    }

    public Binary_Tree(Comparator<? super K> c){
        this(); //인수를 전달받지 않는 생성자 Binary_Tree()를 호출한다. root가 null인(비어있는) 이진검색트리를 생성한다.
        comparator = c; 
    }

    private int comp(K key1, K key2){
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2); //key1 > key2 면 양수, key1 < key2 면 음수, key1 == key2 면 0
    }

    public V search(K key){
        Node<K,V> p = root;

        while(true){
            if(p == null)
                return null;
            int cond = comp(key, p.getKey());
            if(cond == 0) // 같을 경우
                return p.getValue();
            else if(cond < 0) //key쪽이 작을 경우
                p = p.left;
            else //key쪽이 클 경우
                p = p.right;
        }
    }

    public void addNode(Node<K,V> node, K key, V data){ //node를 루트로 하는 서브트리에 노드<K,V>를 삽입
        int cond = comp(key, node.getKey());
        if(cond == 0)
            return;
        else if(cond < 0){
            if(node.left == null)
                node.left = new Node<K,V>(key,data,null,null);
            else
                addNode(node.left,key,data);
        }else{
            if(node.right == null)
                node.right = new Node<K,V>(key,data,null,null);
            else
                addNode(node.right, key, data);
        }
    }

    public void add(K key, V data){ //노드 삽입
        if(root == null)
            root = new Node<K,V>(key, data, null, null);
        else
            addNode(root, key, data);
    }

    public boolean remove(K key){
        Node<K,V> p = root; //스캔 중인 노드
        Node<K,V> parent = null; //스캔 중인 노드의 부모 노드
        boolean isLeftChild = true; //p가 부모의 왼쪽 자식 노드인지 판단

        while(true){
            if(p == null)
                return false;
            int cond = comp(key,p.getKey());
            if(cond == 0)
                break;
            else{
                parent = p;
                if(cond < 0){
                    isLeftChild = true;
                    p = p.left;
                }else{
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        if(p.left == null){
            if(p == root)
                root = p.right;
            else if(isLeftChild)
                parent.left = p.right;
            else
                parent.right = p.right;
        }else if(p.right == null){
            if(p == root)
                root = p.left;
            else if(isLeftChild){
                parent.left = p.left;
            }else{
                parent.right = p.left;
            }
        }else{
            parent = p;
            Node<K,V> left = p.left;
            isLeftChild = true;
            while(left.right != null){
                parent = left;
                left = left.right;
                isLeftChild = false;
            }

            p.key = left.key;
            p.data = left.data;
            if(isLeftChild)
                parent.left = left.left;
            else
                parent.right = left.left;
        }
        return true;
    }

    private void printSubTree(Node node){
        if(node != null){ //중위 순회로 출력을한다.
            printSubTree(node.left);
            System.out.println(node.key + " " + node.data);
            printSubTree(node.right);
        }
    }

    public void print(){ //모든 노드를 키값의 오름차순으로 출력
        printSubTree(root);
    }
}
