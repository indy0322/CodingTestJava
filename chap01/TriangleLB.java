package chap01;

import java.util.Scanner;

class TriangleLB {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("왼쪽 아래가 직각인 이등변삼각형을 출력합니다.");
        int dan;
        

        do{
            System.out.print("몇 단 삼각형입니까?: "); dan = stdIn.nextInt();
        }while(dan < 0);

        for(int i = 0;i < dan;i++){
            for(int j = 0;j < i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }    
}
