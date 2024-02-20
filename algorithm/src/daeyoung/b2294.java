package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 2294
 * 동전 2
 * 골드 5
 * https://www.acmicpc.net/problem/2294
 */
public class b2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //kind of coins
        int k = Integer.parseInt(st.nextToken()); //coin value;

        List<Integer> coins = new ArrayList<>();
        int[] dp = new int[k + 1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int coin = Integer.parseInt(st.nextToken());
            coins.add(coin);
        }

        for(int i = 0; i < k + 1; i++)
            dp[i] = 100001;

        for(int i = 1; i < k + 1; i++) {
            for(int c : coins) {
                if(i - c == 0)
                    dp[i] = 1;
                else if(i - c > 0 && dp[i - c] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        if(dp[k] == 100001)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
