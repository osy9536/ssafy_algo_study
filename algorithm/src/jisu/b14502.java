package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14502 {
	static int[][] fac;
	static int n;
	static int m;
	
	static int ATEAM;
	static int maxi = Integer.MIN_VALUE;
	
	static int[][] dr = new int[][] {{0,1,0,-1},{1,0,-1,0}};
	static List<int[]> virus;
	
	static boolean isOut(int y, int x) {
		if (y < 0 || y >= n) return true;
		if (x < 0 || x >= m) return true;
		if (fac[y][x] != 0) return true;
		return false;
	}
	
	static void nextWall(List<int[]> wall) {
		int wallcnt = wall.size();
		if (wallcnt == 3) {
			safeArea(wall);
			return;
		}
		
		int prey = wall.get(wallcnt-1)[0];
		int prex = wall.get(wallcnt-1)[1];
		
		for (int i = prey; i < n; i++) {
			for (int j = prex+1; j < m; j++) {
				if (isOut(i,j)) continue;
				wall.add(new int[] {i,j});
				nextWall(wall);
				wall.remove(wallcnt);
			}
			prex = -1;
		}
	}
	
	static void safeArea(List<int[]> wall) {
		Queue<int[]> que = new LinkedList<int[]>();
		int vcnt = 0;
		que.addAll(virus);
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < wall.size(); i++) {
			visit[wall.get(i)[0]][wall.get(i)[1]] = true;
		}
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			vcnt++;
			visit[now[0]][now[1]] = true;
			for (int i = 0; i < 4; i++) {
				int y = now[0] + dr[0][i];
				int x = now[1] + dr[1][i];
				if (isOut(y, x) || visit[y][x]) continue;
				que.add(new int[] {y,x});
				visit[y][x] = true;
			}
		}
		
		int result = n*m - vcnt;
		if (result > maxi) maxi = result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		virus = new ArrayList<>();
		int wc = 0;
		
		fac = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				fac[i][j] = Integer.parseInt(st.nextToken());
				if (fac[i][j] == 2) virus.add(new int[] {i,j});
				else if (fac[i][j] == 1) wc++;
			}
		}
		wc+=3;
		
		List<int[]> wall = new ArrayList<>();
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				wall.add(new int[] {i,j});
				nextWall(wall);
				wall.remove(0);
			}
		}
		
		
		System.out.println(maxi-wc);
	}
}

