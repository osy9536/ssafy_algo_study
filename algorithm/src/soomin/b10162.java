package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = 300;
        int B = 60;
        int C = 10;

        int Acnt = 0;
        int Bcnt = 0;
        int Ccnt = 0;

        int T = Integer.parseInt(br.readLine());

        if(T%C != 0) {
            System.out.println(-1);
            return;
        }

        while(true) {

            if(T < C) break;

            // 동전 자판기랑 같음.
            // 큰걸로 나눌 수 있으면 나눈다.
            // 나눈 몫은 해당 A,B,C 버튼이 쓰인 횟수이고, 나머지는 남은 초 이다. 따라서 다음에 다시 계산해야한다.
            if(T >=A) {
                int temp = T;
                T = T%A;
                Acnt = temp/A;
            }else if(T < A && T >=B) {
                int temp = T;
                T = T%B;
                Bcnt = temp/B;
            }else if(T< B && T>=C) {
                int temp = T;
                T = T%C;
                Ccnt = temp/C;
            }
        }

        System.out.printf("%d %d %d",Acnt, Bcnt, Ccnt);

    }
}
