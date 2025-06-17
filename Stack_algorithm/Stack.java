package Stack_algorithm;

import java.util.Scanner;

public class Stack {
    private int[] stack;
    private int capacity;
    private int ptr;

    public class EmptyIntStackException extends RuntimeException { // 스택이 비어 있을 때 예외
        public EmptyIntStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException { // 스택이 가득 찰 때 예외
        public OverflowIntStackException() {}
    }

    public Stack(int max) {
        ptr = 0;
        capacity = max;

        try{
            stack = new int[capacity]; //스택 배열 생성
        }catch(OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException{
        if(ptr >= capacity)
            throw new OverflowIntStackException();
        return stack[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException{
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stack[--ptr];
    }

    public int peek() throws EmptyIntStackException{
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stack[ptr - 1];
    }

    public void clear(){
        ptr = 0;
    }

    public int indexOf(int x){
        for(int i = ptr - 1;i >= 0;i--)
            if(stack[i] == x)
                return i;
            return -1;
    }

    public int getCapacity(){
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull(){
        return ptr >= capacity;
    }

    public void dump() {
        if(ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for(int i = 0;i < ptr;i++)
                System.out.print(stack[i] + " ");
            System.out.println();
        }
    }
}
