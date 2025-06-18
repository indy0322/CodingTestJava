package Sorting;

import java.util.Scanner;

public class SelectionSort {
    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void selectionSort(int[] a, int n){
        for(int i = 0;i < n-1;i++){
            int min = i;
            for(int j = i + 1;j < n;j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            swap(a,i,min);
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

        selectionSort(x, num);

        System.out.println("오름차순 정렬");
        for(int i = 0;i < num;i++){
            System.out.print("x[" + i + "]: " + x[i] + " ");
        }
    }
}
