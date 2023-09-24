package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b2636 {
	static int n, m;
	static int[][] pan;
	static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};

	static boolean isOut(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= m;
	}
	
	static class spot {
		int y,x;

		public spot(int y, int x) {
			super();
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
		int cheese = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				cheese += pan[i][j];
			}
		}
		
		boolean[][] visit = new boolean[n][m];
		Queue<spot> que = new ArrayDeque<>();
		que.add(new spot(0,0));
		visit[0][0] = true;
		while (!que.isEmpty()) {
			spot now = que.poll();
			for (int i = 0; i < 4; i++) {
				int y = now.y + dr[0][i];
				int x = now.x + dr[1][i];
				if (isOut(y,x) || visit[y][x] || pan[y][x] != 0) continue;
				que.add(new spot(y,x));
				visit[y][x] = true;
			}
		}
		
		int lastcheese = cheese;
		int time = 0;
		List<int[]> willmelt = new ArrayList<int[]>();
		for (int i = 0; i < 100; i++) {
			if (cheese == 0) {
				time = i;
				break;
			}
			
			lastcheese = cheese;
			
			for (int[] now : willmelt) {
				visit[now[0]][now[1]] = true;
				que.clear();
				que.add(new spot(now[0], now[1]));
				while (!que.isEmpty()) {
					spot s = que.poll();
					for (int j = 0; j < 4; j++) {
						int y = s.y + dr[0][j];
						int x = s.x + dr[1][j];
						if (isOut(y,x) || pan[y][x] == 1 || visit[y][x]) continue;
						que.add(new spot(y,x));
						visit[y][x] = true;
					}
				}
			}
			
			willmelt.clear();
			
			for (int j = 1; j < n-1; j++) {
				if (cheese == 0) break;
				for (int k = 1; k < m-1; k++) {
					if (cheese == 0) break;
					
					if (pan[j][k] == 1 && !visit[j][k]) {
						for (int g = 0; g < 4; g++) {
							int y = j + dr[0][g];
							int x = k + dr[1][g];
							if (isOut(y,x) || !visit[y][x]) continue;
							else {
								willmelt.add(new int[] {j,k});
								cheese--;
								break;
							}
						}
					}
				}
			}
			
		}
		
		System.out.println(time);
		System.out.println(lastcheese);
		
	}
}
