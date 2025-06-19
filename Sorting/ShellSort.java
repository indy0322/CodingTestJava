package Sorting;

import java.util.Scanner;

public class ShellSort {
    static void shellSort(int[] a, int n){
        for(int h = n/2;h > 0;h /= 2){
            for(int i = h;i < n;i++){
                int j;
                int temp = a[i];
                for(j = i - h;j >= 0 && a[j] > temp;j -= h){
                    a[j + h] = a[j];
                }
                a[j + h] = temp;
            }
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

        shellSort(x, num);

        System.out.println("오름차순 정렬");
        for(int i = 0;i < num;i++){
            System.out.print("x[" + i + "]: " + x[i] + " ");
        }
    }

}
