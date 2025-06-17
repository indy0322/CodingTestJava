package Queue_algorithm;

import java.util.Scanner;;

public class QueueTest {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Queue q = new Queue(15);

        while(true){
            System.out.printf("현재 데이터 개수: %d / %d\n",q.size(),q.getCapacity());
            System.out.print("(1) enqueue (2) dequeue (3) peek (4) dump (0) Quit: ");

            int menu = stdin.nextInt();
            if(menu == 0)
                break;
                
                int x;
                if(menu == 1){
                    System.out.print("데이터: ");
                    x = stdin.nextInt();
                    
                    try{
                        q.enqueue(x);
                    }catch(Queue.OverflowIntOueueException e){
                        System.out.println("큐가 가득 참.");
                    }
                }else if(menu == 2){
                    try{
                        x = q.dequeue();
                        System.out.println("디큐한 데이터는 "+ x +"입니다.");
                    }catch(Queue.EmptyIntQueueException e){
                        System.out.println("큐가 비어있음.");
                    }
                }else if(menu == 3){
                    try{
                        x = q.peek();
                        System.out.println("피크한 데이터는 "+ x + "입니다.");
                    }catch(Queue.EmptyIntQueueException e){
                        System.out.println("큐가 비어있음.");
                    }
                }else if(menu == 4){
                    q.dump();;
                }
        }
    }
}
