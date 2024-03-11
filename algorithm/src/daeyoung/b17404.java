package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 17404
 * RGB거리 2
 * 골드 4
 * https://www.acmicpc.net/problem/17404
 */
public class b17404 {

    static int n;
    static int[][] rgb;

    private static final int INF = 1000 * 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        rgb = new int[n + 1][3];
        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            rgb[i][0] = Integer.parseInt(st.nextToken()); //R
            rgb[i][1] = Integer.parseInt(st.nextToken()); //G
            rgb[i][2] = Integer.parseInt(st.nextToken()); //B
        }

        int[][] dp = new int[n + 1][3];
        int min = INF;

        for(int k = 0; k < 3; k++) {

            for(int i = 0; i < 3; i++) {
                if(i == k)
                    dp[1][i] = rgb[1][i];
                else
                    dp[1][i] = INF;
            }

            for(int i = 2; i < n + 1; i++) {

                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }

//            min = Math.min(dp[n][0], dp[n][1]);
//            min = Math.min(min, dp[n][2]);

            // 정답인 최솟값을 구하는 부분
            for(int i = 0 ; i < 3; i++)
                if(i != k) min = Math.min(min, dp[n][i]);
        }

        System.out.println(min);
    }
}
