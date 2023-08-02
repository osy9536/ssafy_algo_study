package algorithm.soomin;

import java.io.IOException;
import java.util.Scanner;

public class b5622  {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 입력 받아서 낱개의 문자로 나누기
        String s = sc.nextLine();
        char[] chars = new char[s.length()];

        // 걸리는 시간 계산해서 넣는 곳
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        // 문자마다 숫자로 바꿈
        // 숫자에 해당하는 초수로 바꿈
        for (int i = 0; i < s.length(); i++) {
            if((int)chars[i] >=65 && (int)chars[i]<=67 ){
                total +=3;
            }
            else if((int)chars[i] >=68 && (int)chars[i]<=70 ){
                total +=4;
            }
            else if((int)chars[i] >=71 && (int)chars[i]<=73 ){
                total +=5;
            }
            else if((int)chars[i] >=74 && (int)chars[i]<=76 ){
                total +=6;
            }
            else if((int)chars[i] >=77 && (int)chars[i]<=79 ){
                total +=7;
            }
            else if((int)chars[i] >=80 && (int)chars[i]<=83 ){
                total +=8;
            }
            else if((int)chars[i] >=84 && (int)chars[i]<=86 ){
                total +=9;
            }
            else if((int)chars[i] >=87 && (int)chars[i]<=90 ){
                total +=10;
            }

        }
        // 걸리는 시간 더해서 출력
        System.out.println(total);

    }
}

