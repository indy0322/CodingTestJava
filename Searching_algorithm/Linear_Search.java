package Searching_algorithm;

import java.util.Scanner;

class Linear_Search{

    static int linearSearch(int[] a,int n, int key){
        int i = 0;

        while(true){
            if(i == n)
                return -1;
            if(a[i] == key)
                return i;

            i++;
        }
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        System.out.print("배열 크기: ");
        int num = stdin.nextInt();
        int[] x = new int[num];

        for(int i = 0;i < num;i++){
            System.out.print("x[" + i + "]: ");
            x[i] = stdin.nextInt();
        }

        System.out.print("검색할 값: ");
        int key = stdin.nextInt();

        int result = linearSearch(x, num, key);

        if(result == -1)
            System.out.print("존재하지 않는 값입니다");
        else
            System.out.print("그 값은 x[" + result + "]에 있습니다.");
    }
}