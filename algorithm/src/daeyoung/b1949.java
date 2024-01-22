package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 1043
 * 우수 마을
 * 골드 2
 * https://www.acmicpc.net/problem/1949
 */
public class b1949 {

    static int n; //마을 수
    static int[] population; //인구 수
    static List<Integer>[] tree; //인접 정보
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        population = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i ++)
            tree[i] = new ArrayList<Integer>();

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            tree[t1].add(t2);
            tree[t2].add(t1);
        }

        dp = new int[n + 1][2];

        dfs(1, 0);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    public static void dfs(int child, int parent) {



        for(int next : tree[child]) {
            if(next == parent)
                continue;

            dfs(next, child);
            dp[child][0] += Math.max(dp[next][0], dp[next][1]);
            dp[child][1] += dp[next][0];
        }

        dp[child][1] += population[child];

    }

}
