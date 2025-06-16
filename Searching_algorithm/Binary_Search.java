package Searching_algorithm;

import java.util.Scanner;

public class Binary_Search {

    static int binarySearch(int[] a,int n,int key){
        int start = 0;
        int end = n-1;

        do{
            int center = (start + end) / 2;
            if(a[center] == key)
                return center;
            else if(a[center] > key)
                end = center -1;
            else
                start = center +1;
        }while(start <= end);

        return -1;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        int[] x = {1,2,3,4,5,6,7,8,9}; //오름차순 배열

        System.out.print("1~9 중에서 찾으려는 값: ");
        int key = stdin.nextInt();
        int result = binarySearch(x, x.length, key);

        if(result == -1)
            System.out.print("존재하지 않는 값입니다.");
        else
            System.out.print("찾는 값은 x[" + result + "]에 있습니다.");

    }
}
