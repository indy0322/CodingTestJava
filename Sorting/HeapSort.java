package Sorting;

import java.util.Scanner;

public class HeapSort {
    static void swap(int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }
    
    // a[left] ~ a[right]를 힙으로 만든다.
    static void downHeap(int[] a, int left, int right){
      int temp = a[left];     // 루트 노드
      int parent;
      int child;
    
      for(parent = left; parent < (right + 1) / 2; parent = child) {//(right + 1) / 2 는 마지막 부모 노드의 다음 노드 인덱스값(리프 노드의 시작 인덱스)
        int cl = parent * 2 + 1;                            // 왼쪽 자식
        int cr = cl + 1;                                    // 오른쪽 자식
        child = (cr <= right && a[cr] > a[cl]) ? cr : cl;   // 큰 값을 가진 노드를 자식에 대입
    
        if(temp >= a[child]) break;
        else
          a[parent] = a[child];
      }
    
      a[parent] = temp;
    }
    
    // 힙 정렬
    static void heapSort(int[]a,int n) {
      // a[0] ~ a[n-1] 힙정렬 => 부모 노드인 부분부터 반복문 실행
      for(int i = (n - 1) / 2; i >= 0; i--)   // a[i] ~ a[n-1]를 힙으로 만들기
        downHeap(a, i, n - 1);
    
      for(int i = n - 1; i > 0; i--) {
        swap(a, 0, i);                // 가장 큰 요소와 마지막 요소를 교환(힙을 오름차순으로 배열에 정리하는 단계)
        downHeap(a, 0, i - 1);   // a[0] ~ a[i-1]를 힙으로 만듭니다.
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

        heapSort(x,num);

        System.out.println("오름차순 정렬");
        for(int i = 0;i < num;i++){
            System.out.print("x[" + i + "]: " + x[i] + " ");
        }
    }
}
