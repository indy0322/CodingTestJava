package StringSearch;

import java.util.Scanner;

public class KMP {
    static int kmp(String text, String pattern){
        int pt = 1; // text 포인터
        int pp = 0; // pattern 포인터
        int[] skip = new int[pattern.length() + 1]; //건너뛰기 표

        skip[pt] = 0;
        while(pt != pattern.length()){
            if(pattern.charAt(pt) == pattern.charAt(pp))
                skip[++pt] = ++pp;
            else if(pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }

        pt = pp = 0;
        while(pt != text.length() && pp != pattern.length()){
            if(text.charAt(pt) == pattern.charAt(pp)){
                pt++;
                pp++;
            }else if(pp == 0){
                pt++;
            }else{
                pp = skip[pp];
            }
        }

        if(pp == pattern.length())
            return pt - pp;
        return -1;
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        System.out.print("텍스트: ");
        String text = stdin.next();

        System.out.print("패턴: ");
        String pattern = stdin.next();

        int result = kmp(text,pattern);

        if(result == -1){
            System.out.print("텍스트에 일치하는 패턴이 없습니다.");
        }else{
            System.out.println((result+1)+ "번째 문자부터 일치한다.");
        }
    }
}
