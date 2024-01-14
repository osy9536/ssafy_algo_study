package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* SWEA 5607 조합
 * N,R이 주어졌을 때 조합을 구해서 그걸 1234567891로 나눈 나머지를 출력해라
 *
 * */

/*  문제 풀이 방법
 * 	페르마 소정리 이용
 * */

public class b11401 {


    static long [] fac = new long[4000001];
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long A = fac[N];
        long bottom = (fac[N-K]*fac[K])%MOD;

        long B = calPow(bottom, MOD-2);

        System.out.println((A%MOD)*(B%MOD)%MOD );

    }





    private static long calPow(long bottom, long exp) {


        if(exp == 1) {
            return bottom;
        }

        long temp = calPow(bottom, exp/2);
        if(exp%2 == 0) {
            return (temp*temp) % MOD;
        }
        else {
            return ((temp*temp%MOD)*(bottom%MOD))%MOD;
        }



    }





    public static void init() {
        fac[0] = 1;
        for (int i = 1; i < fac.length; i++) {
            fac[i] = fac[i-1] * i%MOD;
        }
    }

}
