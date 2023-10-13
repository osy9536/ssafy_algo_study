package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 행렬 곱셈 순서
// gold 3
public class b11049 {
    static int [][] a;
    static int [][] dp;

    public static int solve( int start, int end) {
        if(start == end) return 0;
        if(dp[start][end]!= Integer.MAX_VALUE) {
            return dp[start][end];
        }
        for(int i=start; i<end; i++) {
            int cost = solve(start, i)+solve(i+1, end)+ a[start][0] * a[i][1] * a[end][1];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
        return dp[start][end];
    }

    public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        a = new int[n][2];
        dp = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(solve(0, n-1));
    }
}
