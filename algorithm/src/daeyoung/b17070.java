package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17070
 * 파이프 옮기기1
 * 골드 5
 * https://www.acmicpc.net/problem/17070
 */
public class b17070 {
	static int n;
	static int[][] map;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 1, 1, 2);
		
		System.out.println(cnt);
		
	}
	
	public static void dfs(int r1, int c1, int r2, int c2) {
		if(r2 == n && c2 == n) {
			cnt += 1;
			return;
		}
		
		if (r1 >= n + 1 || c1 >= n + 1 || 
				r2 >= n + 1 || c2 >= n + 1 )
			return;
			
		//가로 일때
		if(r1 == r2) {
			if(c2 < n && map[r2][c2 + 1] != 1)
				dfs(r2, c2, r2, c2 + 1);
			
			if(r2 < n && c2 < n && map[r2 + 1][c2] != 1 && map[r2 + 1][c2 + 1] != 1 && map[r2][c2 + 1] != 1)
				dfs(r2, c2, r2 + 1, c2 + 1);
		}
		
		
		//세로일때
		if(c2 == c1) {
			if(r2 < n && map[r2 + 1][c2] != 1)
				dfs(r2, c2, r2 + 1, c2);
			
			if(r2 < n && c2 < n && map[r2 + 1][c2] != 1 && map[r2 + 1][c2 + 1] != 1 && map[r2][c2 + 1] != 1)
				dfs(r2, c2, r2 + 1, c2 + 1);
		}
		
		
		//대각선일때
		if(r2 - r1 == 1 && c2 - c1 == 1) {
			if(c2 < n && map[r2][c2 + 1] != 1)
				dfs(r2, c2, r2, c2 + 1);
			if(r2 < n && map[r2 + 1][c2] != 1)
				dfs(r2, c2, r2 + 1, c2);
			if(r2 < n && c2 < n && map[r2 + 1][c2] != 1 && map[r2 + 1][c2 + 1] != 1 && map[r2][c2 + 1] != 1)
				dfs(r2, c2, r2 + 1, c2 + 1);
		}
		
	}
}
