package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b13903 {
	static int r, c;
	static boolean isOut(int y, int x) {
		return y < 0 || y >= r || x < 0 || x >= c;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[][] road = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		int[][] dr = new int[n][2];
		for (int i = 0; i < dr.length; i++) {
			st = new StringTokenizer(br.readLine());
			dr[i][0] = Integer.parseInt(st.nextToken());
			dr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] visit = new boolean[r][c];
		Queue<int[]> que = new ArrayDeque<>();
		for (int i = 0; i < c; i++) {
			if (road[0][i] == 1) {
				que.add(new int[] {0, i, 0});
				visit[0][i] = true;
			}
		}
		
		int answer = -1;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			if (now[0] == r-1) {
				answer = now[2];
				break;
			}
			for (int i = 0; i < n; i++) {
				int y = dr[i][0] + now[0];
				int x = dr[i][1] + now[1];
				if (isOut(y,x) || visit[y][x] || road[y][x] == 0) continue;
				que.add(new int[] {y, x, now[2]+1});
				visit[y][x] = true;
			}
		}
		
		System.out.println(answer);
	}
}
