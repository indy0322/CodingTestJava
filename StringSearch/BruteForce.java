package StringSearch;

import java.util.Scanner;

public class BruteForce {
    static int bf(String text, String pattern){
        int pt = 0;
        int pp = 0;

        while(pt != text.length() && pp != pattern.length()){
            if(text.charAt(pt) == pattern.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if(pp == pattern.length()){
            return pt - pp;
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        System.out.print("텍스트: ");
        String text = stdin.next();

        System.out.print("패턴: ");
        String pattern = stdin.next();

        int result = bf(text,pattern);

        if(result == -1){
            System.out.print("텍스트에 일치하는 패턴이 없습니다.");
        }else{
            System.out.println((result+1)+ "번째 문자부터 일치한다.");
        }
    }
}
