package chap01;

import java.util.Scanner;

class JudgeABC1 {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int num = stdIn.nextInt();

        if(num == 1)
            System.out.println("A");
        else if(num == 2)
            System.out.println("B");
        else
            System.out.println("C");
    }
    
}
