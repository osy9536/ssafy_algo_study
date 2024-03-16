package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 14002
 * 가장 긴 증가하는 부분 수열 4
 * 골드 4
 * https://www.acmicpc.net/problem/14002
 */
public class b14002 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;

        for(int i = 1; i < n + 1; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(ary[i] > ary[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);

                    max = Math.max(max, dp[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        int len = max;
        Stack<Integer> s = new Stack<>();
        for(int i = n; i >= 1; i--) {
            if(len == dp[i]) {
                s.add(ary[i]);
                len--;
            }
        }

        while(!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
