package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 1309
 * 동물원
 * 실버 1
 * https://www.acmicpc.net/problem/1309
 */
public class b1309 {
  
    static long d = 9901;

    public static void main(String[] args) throws IOException {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for(int i = 2; i < n + 1; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % d;

            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % d;

            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % d;
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % d);
    }
}
