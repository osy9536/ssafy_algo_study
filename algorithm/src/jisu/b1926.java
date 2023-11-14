package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1926 {
	
	static int r, c, maxi;
	static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
	static int[][] map;
	static boolean[][] visit;
	
	static boolean isOut(int y, int x) {
		return y < 0 || y >= r || x < 0 || x >= c;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		visit = new boolean[r][c];
		ArrayDeque<int[]> que = new ArrayDeque<>();
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) que.add(new int[] {i,j,0});
			}
		}
		
		List<Integer> list = new ArrayList<>();
		while (!que.isEmpty()) {
			int[] now = que.pollLast();
			int y = now[0];
			int x = now[1];
			if (visit[y][x]) continue;
			visit[y][x] = true;
			if (now[2] == 0) list.add(1);
			else list.set(list.size()-1, list.get(list.size()-1)+1);
			for (int i = 0; i < 4; i++) {
				int w = y + dr[0][i];
				int v = x + dr[1][i];
				if (isOut(w,v) || visit[w][v] || map[w][v] == 0) continue;
				que.add(new int[] {w,v,1});
				
			}
		}
		
		maxi = 0;
		for (int i : list) {
			if (i > maxi) maxi = i;
		}
		
		System.out.println(list.size());
		System.out.println(maxi);
		
		
		
	}
}
