package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b2096 {
	static int n;
	static int result = Integer.MIN_VALUE;
	
	static int[][] pan;

	static int[][] dp;
	static int[][] dpmin;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		pan = new int[n][3];
		dp = new int[n][3];
		dpmin = new int[n][3];
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 3; i++) {
			dp[0][i] = pan[0][i];
			dpmin[0][i] = pan[0][i];
			
		}
		
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + pan[i][0];
			dpmin[i][0] = Math.min(dpmin[i-1][0], dpmin[i-1][1]) + pan[i][0];
			
			dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + pan[i][1];
			dpmin[i][1] = Math.min(dpmin[i-1][0], Math.min(dpmin[i-1][1], dpmin[i-1][2])) + pan[i][1];
			
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + pan[i][2];
			dpmin[i][2] = Math.min(dpmin[i-1][1], dpmin[i-1][2]) + pan[i][2];
		}
		
		int maxi = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
		int mini = Math.min(dpmin[n-1][0], Math.min(dpmin[n-1][1], dpmin[n-1][2]));
		
		
		System.out.println(maxi + " " + mini);
	}
}
