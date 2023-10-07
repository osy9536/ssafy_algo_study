package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b2638 {
	static int n, m;
	static int[][] pan;
	static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};

	static boolean isOut(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= m;
	}
	
	static class WV {
		int y,x;
		public WV(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		pan = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		int[][] check = new int[n][m];
		
		int checnt = 0;
		
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				pan[i][j]  = Integer.parseInt(st.nextToken());
				if (pan[i][j] == 1) checnt++;
			}
		}
		
		Queue<WV> que = new ArrayDeque<>();
		while (checnt != 0) {
			result++;
			que.clear();
			visit = new boolean[n][m];
			check = new int[n][m];
			que.add(new WV(0,0));
			visit[0][0] = true;
			
			while (!que.isEmpty()) {
				WV now = que.poll();
				for (int i = 0; i < 4; i++) {
					int y = now.y + dr[0][i];
					int x = now.x + dr[1][i];
					if (isOut(y,x) || visit[y][x]) continue;
					if (pan[y][x] == 0) {
						visit[y][x] = true;
						que.add(new WV(y,x));
					} else {
						check[y][x]++;
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (check[i][j] >= 2) {
						pan[i][j] = 0;
						checnt--;
					}
				}
			}
		}
		
		
		System.out.println(result);
		
	}
}
