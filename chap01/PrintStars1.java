package chap01;

import java.util.Scanner;

class PrintStars1 {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n;
        int w;
        System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");
        
        do{
            System.out.print("n값: "); n = stdIn.nextInt();
        }while(n <= 0);
        
        do{
            System.out.print("w값: "); w = stdIn.nextInt();
        }while(w <= 0);

        for(int i = 0;i < n;i++){
            if(i % w == 0){
                System.out.println("");
            }
            System.out.print("*");
        }
    }
}
