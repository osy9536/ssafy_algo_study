package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 1005
 * ACM Craft
 * 골드 3
 * https://www.acmicpc.net/problem/1005
 */
public class b1005 {

    static int[] times; //건설 걸리는 시간
    static List<Integer>[] g; //건설 규칙
    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken()); //test case
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); //빌딩 개수
            int k = Integer.parseInt(st.nextToken()); //건설 순서 규칙 총개수

            times = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                times[j] = Integer.parseInt(st.nextToken());
            }

            g = new ArrayList[n + 1];
            for(int j = 1; j < n + 1; j++) {
                g[j] = new ArrayList<Integer>();
            }

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int d1 = Integer.parseInt(st.nextToken());
                int d2 = Integer.parseInt(st.nextToken());

                g[d2].add(d1);
            }

            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            dp = new long[n + 1];
            Arrays.fill(dp, -1);
            dfs(w);
            sb.append(dp[w]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int cur) {
        if(dp[cur] != -1)
            return;

        long max = 0;
        for(int next : g[cur]) {
            dfs(next);
            max = Math.max(max, dp[next]);
        }

        max += times[cur];
        dp[cur] = max;
    }
}
