package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b9465 { 

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][n];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[2][n];
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					int my = j;
					int you = j == 0 ? 1 : 0;
					
					int a = dp[my][i-1] - arr[my][i-1] + arr[my][i];
					int b = dp[you][i-1] + arr[my][i];
					
					dp[my][i] = Math.max(a, b);
				}
			}
			
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
		
		
		
	}
}
