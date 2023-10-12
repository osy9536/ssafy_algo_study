package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 17069
 * 파이프 옮기기 2
 * https://www.acmicpc.net/problem/17069
 */
public class b17069 {
	
	static int[][] home;
	static long[][][] dp; // 0  가로, 1 세로, 2 대각

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		
		home = new int[n][n];
		dp = new long[n][n][3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][1][0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++) {
				
				if(i==0 && j<2) continue;
				
				if(home[i][j] == 1)
					continue;
				
				if(i - 1 >= 0 && 
						home[i - 1][j - 1] != 1 &&
						home[i -1][j] != 1 &&
						home[i][j - 1] != 1) {
					dp[i][j][2] = dp[i - 1][j - 1][0] + 
							dp[i - 1][j - 1][1] +
							dp[i - 1][j - 1][2];
				}
				
				//세로
				if(i - 1 >= 0 && home[i - 1][j] != 1)
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				
				//가로
				if(home[i][j - 1] != 1)
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
			}
		}
		
		System.out.println(dp[n-1][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n-1][2]);
	}
	
	
}
