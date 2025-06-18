package Sorting;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void bubbleSort(int[] a, int n){
        for(int i = 0;i < n-1;i++){
            for(int j = 0;j < n-1-i;j++){
                if(a[j] > a[j+1]){
                    swap(a,j,j+1);
                }
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

        bubbleSort(x, num);

        System.out.println("오름차순 정렬");
        for(int i = 0;i < num;i++){
            System.out.print("x[" + i + "]: " + x[i] + " ");
        }
    }

}
