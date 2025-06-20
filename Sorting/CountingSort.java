package Sorting;

import java.util.Scanner;

public class CountingSort {
    static void countingSort(int[] a, int n, int max){
        int[] f = new int[max + 1];
        int[] b = new int[n];

        for(int i = 0;i < n;i++) f[a[i]]++; //1단계
        for(int i = 1;      i <= max;   i++) f[i] += f[i - 1]; // 2단게
        for(int i = n - 1;  i >= 0;     i--) b[--f[a[i]]] = a[i]; // 3단게
        for(int i = 0;      i < n;      i++) a[i] = b[i]; //4단계
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        System.out.print("배열 크기: ");
        int num = stdin.nextInt();
        int[] x = new int[num];

        for(int i=0;i<num;i++){
            System.out.print("x[" + i + "]: ");
            x[i] = stdin.nextInt();
        }

        int max = x[0];
        for(int i = 0;i < num;i++){
            if(max < x[i]){
                max = x[i];
            }
        }

        countingSort(x, num, max);

        System.out.println("오름차순 정렬");
        for(int i = 0;i < num;i++){
            System.out.print("x[" + i + "]: " + x[i] + " ");
        }
    }
}
