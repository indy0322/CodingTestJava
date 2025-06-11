package chap02;

import java.util.Scanner;

class CardConv {
    static int cardConv(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do{
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        }while(x != 0); 

        for(int i = 0;i < digits / 2;i++){
            char t = d[i];
            d[i] = d[digits - i -1];
            d[digits - i -1] = t;
        }//정수 x를 r진수로 변환하고 char형 배열 d에 넣어 두고 그 자리수(배열에 넣어둔 문자 수)를 반환

        return digits;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int num;//변환하는 정수
        int card; //기수
        int dnum; //변환후의 자릿 수

        char[] cno = new char[32];

        System.out.println("10진수를 기수 변환합니다.");
        
        do{
            System.out.print("변환하는 음이 아닌 정수: ");
            num = stdin.nextInt();
        }while(num < 0);

        do{
            System.out.print("어떤 진수로 변환할까요? (2~36): ");
            card = stdin.nextInt();
        }while(card < 2 || card > 36);

        dnum = cardConv(num, card, cno);

        System.out.print(card + "진수로 ");
        for(int i = 0;i < dnum;i++){
            System.out.print(cno[i]);
        }
        System.out.println("입니다.");

            
        
    }
}
