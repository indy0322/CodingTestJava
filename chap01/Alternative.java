package chap01;

import java.util.Scanner;

class Alternative {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("+와 -를 번갈아 n개 출력합니다.");
        System.out.print("n값: "); int n = stdIn.nextInt();

        for(int i = 0;i < n;i++){
            if(i % 2 == 0){
                System.out.print("+");
            }else{
                System.out.print("-");
            }
            
        }
    }
}
