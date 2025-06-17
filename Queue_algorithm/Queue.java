package Queue_algorithm;

import java.util.Scanner;

public class Queue {
    private int[] queue;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public class EmptyIntQueueException extends RuntimeException { // 큐가 비어 있을 때 예외
        public EmptyIntQueueException() {}
    }

    public class OverflowIntOueueException extends RuntimeException { // 큐가 가득 찰 때 예외
        public OverflowIntOueueException() {}
    }

    public Queue(int max){
        num = front = rear = 0;
        capacity = max;
        try{
            queue = new int[capacity];
        }catch(OutOfMemoryError e){
            capacity = 0;
        }
    }

    public int enqueue(int x) throws OverflowIntOueueException {
        if(num >= capacity)
            throw new OverflowIntOueueException();

        queue[rear++] = x;
        num++;

        if(rear == capacity)
            rear = 0;
        return x; 
    }

    public int dequeue() throws EmptyIntQueueException {
        if(num <= 0)
            throw new EmptyIntQueueException();

        int x = queue[front++];
        num--;

        if(front == capacity)
            front = 0;
        
        return x;
    }

    public int peek() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();
        
        return queue[front];
    }

    public void clear(){
        num = front = rear = 0;
    }

    public int indexOf(int x){
        for(int i = 0;i < num;i++){
            int idx = (i + front) % capacity; //배열의 물리적인 첫 요소가 아닌 큐의 논리적인 첫요소(front)에서 시작하기 위함.
            if(queue[idx] == x)
                return idx;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size(){
        return num;
    }

    public boolean isEmpty(){
        return num <= 0;
    }

    public boolean isFull(){
        return num >= capacity;
    }

    public void dump() {
        if(num <= 0)
            System.out.println("큐가 비어있음.");
        else{
            for(int i = 0;i < num;i++){
                int idx = (i + front) % capacity;
                System.out.print(queue[idx] + " ");
            }
            System.out.println();
        }
    }
}
