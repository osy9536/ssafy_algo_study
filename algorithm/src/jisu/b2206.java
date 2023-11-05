package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b2206 { 
	
	static int n, m;
	static int[][] map;
	static int[][][] visit;
	static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
	static int result = Integer.MAX_VALUE;
	
	public static boolean isOut(int y, int x) {
		return y >= n || x >= m || y < 0 || x < 0;
	}
	
	static class Node {
		int y, x, cnt;
		boolean crush;
		
		public Node(int y, int x, int cnt, boolean crush) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.crush = crush;
		}
	}

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				visit[i][j][0] = Integer.MAX_VALUE;
				visit[i][j][1] = Integer.MAX_VALUE;
			}
		}
		

		Queue<Node> que = new ArrayDeque<>();
		
		
		
		que.add(new Node(0,0,1, true));
		visit[0][0][0] = 1;
		visit[0][0][1] = 1;
		
		
		while (!que.isEmpty()) {
			Node now = que.poll();
			if (now.y == n-1 && now.x == m-1) {
				if (result > now.cnt) result = now.cnt;
				continue;
			}
			if (now.cnt >= result) continue;
			
			for (int i = 0; i < 4; i++) {
				int y = now.y + dr[0][i];
				int x = now.x + dr[1][i];
				if (isOut(y,x)) continue;
				if ((!now.crush && map[y][x] == 0) || (map[y][x] == 1 && now.crush)) {
					if (visit[y][x][1] > now.cnt+1) {
						que.add(new Node(y,x,now.cnt+1, false));
						visit[y][x][1] = now.cnt+1;
					}
				} else if (map[y][x] == 0) {
					if (visit[y][x][0] > now.cnt+1) {
						que.add(new Node(y,x,now.cnt+1, true));
						visit[y][x][0] = now.cnt+1;
						visit[y][x][1] = Math.min(visit[y][x][1], now.cnt+1);
					}
				}
				
			}
		}
		
		
		if (result == Integer.MAX_VALUE) result = -1;
		
		System.out.println(result);
	}
}
