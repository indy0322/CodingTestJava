package Recursive;

import java.util.Scanner;

public class EuclidGCD {
    static int gcd(int x, int y){
        if(y==0)
            return x;
        else
            return gcd(y,x % y);
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        System.out.print("x값 입력: ");
        int x = stdin.nextInt();

        System.out.print("y값 입력: ");
        int y = stdin.nextInt();

        System.out.println("최대공약수는 " + gcd(x,y) + "입니다.");

    }
}
