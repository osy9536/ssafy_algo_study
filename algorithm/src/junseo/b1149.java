package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1149 {

    static int[][] cost; //red,green,blue
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        cost = new int[3][N];
        dp = new int[3][N];
        for (int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[0][i] = Integer.parseInt(st.nextToken());
            cost[1][i] = Integer.parseInt(st.nextToken());
            cost[2][i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = cost[0][0];
        dp[1][0] = cost[1][0];
        dp[2][0] = cost[2][0];

        System.out.println(Math.min(sol(N-1,0),Math.min(sol(N-1,1),sol(N-1,2))));
    }

    private static int sol(int N,int color) {
        if(dp[color][N] == 0){
            if(color == 0){
                dp[color][N] = Math.min(sol(N-1,1),sol(N-1,2))+cost[0][N];
            }
            else if(color == 1){
                dp[color][N] = Math.min(sol(N-1,0),sol(N-1,2))+cost[1][N];
            }
            else{
                dp[color][N] = Math.min(sol(N-1,0),sol(N-1,1))+cost[2][N];
            }
        }
        return dp[color][N];
    }
}



