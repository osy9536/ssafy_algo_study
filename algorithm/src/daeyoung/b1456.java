package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 1456
 * 거의 소수
 * 골드 5
 * https://www.acmicpc.net/problem/1456
 */
public class b1456 {

    static long A;
    static long B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(countingPrime());
    }

    public static int countingPrime() {

        int count = 0;
        boolean[] prime = new boolean[10000001];

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(10000000); i++) {
            if(!prime[i]) {
                for(int j = i*i; j <= 10000000; j += i)
                    prime[j] = true;
            }
        }

        for(int i = 2; i < 10000001; i++)
            if(!prime[i]) {
                long c = i;

                while(c < Long.MAX_VALUE / i) {
                    c *= i;
                    if(c > B)
                        break;
                    if(A <= c)
                        count += 1;
                }

            }


        return count;
    }
}
