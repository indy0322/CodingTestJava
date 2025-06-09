package chap01;

import java.util.Scanner;

class SumWhile {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        int sum = 0;
        int i = 1;
        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n값: "); int n = stdIn.nextInt();

        while(n >= i){
            sum += i;
            i++;
        }
        System.out.println("1부터 5까지의 합은 " + sum + "입니다.");
    }
}
