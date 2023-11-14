package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1743 {
	static int n, m, k;
	
	static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
	
	static boolean isOut(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= m;
	}

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[n][m];
		boolean[][] visit = new boolean[n][m];
		
		ArrayDeque<int[]> que = new ArrayDeque<>();
//		visit[0][0] = true;
//		que.add(new int[] {0,0});
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			w--;
			v--;
			
			map[w][v] = true;
			que.add(new int[] {w,v, 0});
		}
		
		List<Integer> list = new ArrayList<>();
		

		while(!que.isEmpty()) {
			int[] now = que.pollLast();
			if (visit[now[0]][now[1]]) continue;
			if (now[2] == 0) list.add(1);
			else list.set(list.size()-1, list.get(list.size()-1)+1);
			visit[now[0]][now[1]] = true;
			for (int i = 0; i < 4; i++) {
				int w = now[0] + dr[0][i];
				int v = now[1] + dr[1][i];
				
				if (isOut(w,v) || !map[w][v] || visit[w][v]) continue;
				
				que.add(new int[] {w,v, 1});
				
			}
		}
		
		int maxi = 0;
		for (int i : list) {
			if (maxi < i) maxi = i;
		}
		
		System.out.println(maxi);
	}
}
