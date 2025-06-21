package Recursive;

import java.util.Scanner;

public class Factorial{
    static int factorial(int n){
        if(n > 0)
            return n * factorial(n-1);
        else
            return 1;
    }
    
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        System.out.print("정수 입력: ");
        int num = stdin.nextInt();

        int result = factorial(num);

        System.out.println(num + "!은 " + result + "입니다.");
    }
}