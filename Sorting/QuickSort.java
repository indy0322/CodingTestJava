package Sorting;

import java.util.Scanner;

public class QuickSort {
    static void swap(int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void quickSort(int[] a,int left, int right){
        int pl = left;
        int pr = right;
        int pivot = a[(pl + pr) / 2];

        do{
            while(a[pl] < pivot) pl++;
            while(a[pr] > pivot) pr--;
            if(pl <= pr)
                swap(a, pl++, pr--);
        }while(pl <= pr);

        if(left < pr)
            quickSort(a, left, pr);
        
        if(right > pl)
            quickSort(a, pl, right);
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

        quickSort(x, 0, num-1);

        System.out.println("오름차순 정렬");
        for(int i = 0;i < num;i++){
            System.out.print("x[" + i + "]: " + x[i] + " ");
        }
    }
}
