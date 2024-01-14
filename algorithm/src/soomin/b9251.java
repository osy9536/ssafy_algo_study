package algorithm.src.soomin;

import java.util.*;
import java.io.*;

public class b9251{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] strArr1 = br.readLine().toCharArray();
        char [] strArr2 = br.readLine().toCharArray();

        int N = strArr1.length;
        int M = strArr2.length;

        int [][] dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(strArr1[i-1] == strArr2[j-1] && dp[i][j-1] < i){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[N][M]);




    }
}
