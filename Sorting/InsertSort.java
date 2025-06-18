package Sorting;

import java.util.Scanner;

public class InsertSort {
    
    static void insertSort(int[] a, int n){
        for(int i = 1;i < n;i++){
            int j;
            int temp = a[i];
            for(j = i;j > 0 && a[j-1]>temp;j--){
                a[j] = a[j-1];
            }
            a[j] = temp;
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

        insertSort(x, num);

        System.out.println("오름차순 정렬");
        for(int i = 0;i < num;i++){
            System.out.print("x[" + i + "]: " + x[i] + " ");
        }
    }
}
