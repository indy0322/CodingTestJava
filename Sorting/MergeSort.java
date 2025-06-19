package Sorting;

import java.util.Scanner;

public class MergeSort {
    static void mergeSort(int[] a, int na, int[] b, int nb, int[] c){
        int pa = 0;
        int pb = 0;
        int pc = 0;

        while(pa < na && pb < nb){
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
        }

        while(pa <na)
            c[pc++] = a[pa++];

        while(pb < nb)
            c[pc++] = b[pb++];
    }

    public static void main(String[] args){
        int[] a = {2,4,6,8,10,12};
        int[] b = {1,3,5,7,9,11};
        int[] c = new int[12];

        mergeSort(a,a.length,b,b.length,c);

        System.out.println("배열 병합 결과: ");

        for(int i = 0;i < c.length;i++){
            System.out.print("c[" + i + "]: " + c[i] + " ");
        }
        System.out.println();
    }
}
