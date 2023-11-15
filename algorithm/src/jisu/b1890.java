package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1890 {
	static int n;
	static int[][] map;
//	static boolean[][] visit;
	static long[][] dp;
	static long result;
	
	static boolean isOut(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= n;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new long[n][n];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int dr = map[i][j];
				if (dr == 0) continue;
				if (!isOut(i+dr, j)) {
					dp[i+dr][j] += dp[i][j]; 
				}
				if (!isOut(i, j+dr)) {
					dp[i][j+dr] += dp[i][j];
				}
			}
			
		}
		
		System.out.println(dp[n-1][n-1]);
		
	}
}
