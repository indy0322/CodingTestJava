package Stack_algorithm;

import java.util.Scanner;

public class StackTest {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Stack s = new Stack(15);

        while (true) {
            System.out.printf("현재 데이터 개수: %d / %d\n",s.size(),s.getCapacity());
            System.out.print("(1) push (2) pop (3) peek (4) dump (0) Quit: ");

            int menu = stdin.nextInt();
            if(menu == 0)
                break;

            int x;
            if(menu == 1){
                System.out.print("데이터: ");
                x = stdin.nextInt();
                
                try{
                    s.push(x);
                }catch(Stack.OverflowIntStackException e){
                    System.out.println("스택이 가득 참.");
                }
            }else if(menu == 2){
                try{
                    x = s.pop();
                    System.out.println("팝한 데이터는 "+ x +"입니다.");
                }catch(Stack.EmptyIntStackException e){
                    System.out.println("스택이 비어있음.");
                }
            }else if(menu == 3){
                try{
                    x = s.peek();
                    System.out.println("피크한 데이터는 "+ x + "입니다.");
                }catch(Stack.EmptyIntStackException e){
                    System.out.println("스택이 비어있음.");
                }
            }else if(menu == 4){
                s.dump();
            }
        }
    }
}
