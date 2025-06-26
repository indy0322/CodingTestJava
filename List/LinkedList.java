package List;

import java.util.Scanner;
import java.util.Comparator;

public class LinkedList<E> {
    
    class Node<E>{
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public LinkedList(){
        head = crnt = null;
    }

    public E search(E obj, Comparator<? super E> c){//Comparator는 객체를 사용자 정의 기준으로 비교(정렬)할 수 있게 해주는 인터페이스
        Node<E> ptr = head;

        while(ptr != null){
            if(c.compare(obj, ptr.data) == 0){ //c.compare()이 같으면 0을 반환한다.
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void addFirst(E obj){//머리에 노드를 삽입.
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    public void addLast(E obj){
        if(head == null)
            addFirst(obj);
        else{
            Node<E> ptr = head;
            while(ptr.next != null)
                ptr = ptr.next;
            ptr.next = crnt = new Node<E>(obj,null);
        }
    }

    public void removeFirst() {
        if(head != null)
            head = crnt = head.next;
    }

    public void removeLast(){
        if(head != null){
            if(head.next == null)
                removeFirst();
            else{
                Node<E> ptr = head; //스캔 중인 노드
                Node<E> pre = head; //스캔 중인 노드의 앞쪽 노드

                while(ptr.next != null){
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null; //pre가 삭제 후의 꼬리 노드가 된다. 
                crnt = pre;
            }
        }
    }

    public void remove(Node<E> p){
        if(head != null){
            if(p == head)
                removeFirst();
        }else{
            Node<E> ptr = head;

            while(ptr.next != p){
                ptr = ptr.next;
                if(ptr == null)
                    return; //p가 리스트에 없음.
            }
            ptr.next = p.next;
            crnt = ptr;
        }
    }

    public void clear(){
        while(head != null)
            removeFirst();
        crnt = null;
    }

    public void dump(){
        Node<E> ptr = head;

        while(ptr != null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}


