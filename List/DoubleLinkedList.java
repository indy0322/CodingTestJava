package List;

import java.util.Comparator;

public class DoubleLinkedList<E> {
    
    class Node<E>{
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node(){
            data = null;
            prev = next = this; //자기 자신의 노드가 앞쪽이면서 동시에 다음 노드가 된다.
        }

        Node(E data, Node<E>prev, Node<E> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public DoubleLinkedList(){
        head = crnt = new Node<E>(); //데이터를 갖지 않는 노드를 1개만 만든다. 노드의 삽입과 삭제를 원활하게 처리하기 위한 머리에 계속 존재하는 더미 노드를 갖는다.
    }

    public boolean isEmpty(){
        return head.next == head; //더미 노드의 뒤쪽 포인터 head.next가 더미 노드인 head를 가리키고 있다.(리스트에 더미노드 밖에 없다.)
    }

    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head.next;

        while(ptr != head){
            if(c.compare(obj, ptr.data) == 0){
                crnt = ptr;
                return ptr.data;
            }

            ptr = ptr.next;
        }
        return null;
    }

    public void printCurrentNode(){ //선택 노드를 출력
        if(isEmpty())
            System.out.println("선택 노드가 없다.");
        else
            System.out.println(crnt.data);
    }

    public void dump(){
        Node<E> ptr = head.next;

        while(ptr != head){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    public void dumpReverse(){
        Node<E> ptr = head.prev;

        while(ptr != head){
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    public boolean next(){
        if(isEmpty() || crnt.prev == head) //노드가 없음.
            return false;
        crnt = crnt.next;
        return true;
    }

    public boolean prev(){
        if(isEmpty() || crnt.prev == head) //노드가 없음.
            return false;
        crnt = crnt.prev;
        return true;
    }

    public void add(E obj){//선택한 노드 바로 뒤에 노드를 삽입
        Node<E> node = new Node<E>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    public void addFirst(E obj){
        crnt = head; //더미 노드 head의 바로 뒤에 삽입 
        add(obj);
    }

    public void addLast(E obj){
        crnt = head.prev; //더미 노드 head의 전으로 가면 꼬리 노드로 가게 된다. 꼬리 노드 바로 뒤에 삽입
        add(obj); 
    }

    public void removeCurrentNode(){
        if(!isEmpty()){
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;

            if(crnt == head)
                crnt = head.next;
        }
    }

    public void remove(Node<E> p){
        Node<E> ptr = head.next;

        while(ptr != head){
            if(ptr == p){
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    public void removeFirst(){ //머리 노드(더미 노드) head.next를 삭제
        crnt = head.next;
        removeCurrentNode();
    }

    public void removeLast(){
        crnt = head.prev;
        removeCurrentNode();
    }

    public void clear(){
        while(isEmpty()){
            removeFirst();
        }
    }
}
