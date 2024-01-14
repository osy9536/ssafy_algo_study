package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 1932
 * 정수 삼각형
 * 실버 1
 * https://www.acmicpc.net/problem/1932
 */
public class b1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //삼각형의 크기

        int[][] t = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];

        dp[0][0] = t[0][0];

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j <= i; j++) {
                dp[i + 1][j] = Math.max(dp[i][j] + t[i + 1][j], dp[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i][j] + t[i + 1][j + 1], dp[i + 1][j + 1]);
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);

    }
}
