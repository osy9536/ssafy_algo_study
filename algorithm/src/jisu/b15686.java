package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b15686 { 
	static int n;
	static int m;
	static int[][] dosi;
	static List<int[]> zip;
	static List<int[]> chick;
	static int mini = Integer.MAX_VALUE;
	
	static int[][] dr = new int[][] {{0,1,0,-1}, {1,0,-1,0}};
	
	public static boolean isOut(int y, int x) {
		if (y < 0 || y >= n || x < 0 || x >= n) return true;
		return false;
	}
	
	public static void guriCal(List<int[]> pick) {
		int guri = 0;
		for (int[] z : zip) {
			int gmin = Integer.MAX_VALUE;
			for (int[] pc : pick) {
				int temp = Math.abs(pc[0]-z[0])+Math.abs(pc[1]-z[1]);
				if (temp < gmin) gmin = temp;
			}
			guri += gmin;
			if (guri > mini) return;
		}
		if (guri < mini) mini = guri;
	}
	
	/* 거리 계산 이렇게 bfs로 때리면 시간 초과 난다
	public static void chickenguri(List<int[]> pick) {
		int guri = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		Queue<Integer> cntque = new LinkedList<Integer>();
		boolean[][] visit = new boolean[n][n];
		
		boolean[][] pickchick = new boolean[n][n];
		for (int[] pc : pick) {
			pickchick[pc[0]][pc[1]] = true;
		}
		
		for (int[] z : zip) {
			que.clear();
			cntque.clear();
			que.add(z);
			cntque.add(0);
			visit = new boolean[n][n];
			visit[z[0]][z[1]] = true;
			
			while (!que.isEmpty()) {
				int[] now = que.poll();
				int cnt = cntque.poll();
				if (pickchick[now[0]][now[1]]) {
					guri += cnt;
					if (guri >= mini) return;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int y = now[0] + dr[0][i];
					int x = now[1] + dr[1][i];
					if (isOut(y,x) || visit[y][x]) continue;
					que.add(new int[] {y,x});
					cntque.add(cnt+1);
					visit[y][x] = true;
				}
			}
		}
		
		if (guri < mini) mini = guri;
	}
	*/
	public static void select(List<int[]> pick, int p) {
		if (pick.size() >= m) {
			guriCal(pick);
			return;
		}
		if (p >= chick.size() || chick.size()-p < m - pick.size()) return;
		
		select(pick, p+1);
		List<int[]> newpick = new ArrayList<int[]>();
		newpick.addAll(pick);
		newpick.add(chick.get(p));
		select(newpick, p+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		dosi = new int[n][n];
		zip = new ArrayList<int[]>();
		chick = new ArrayList<int[]>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				dosi[i][j] = Integer.parseInt(st.nextToken());
				if (dosi[i][j] == 1) zip.add(new int[] {i,j});
				else if (dosi[i][j] == 2) chick.add(new int[] {i,j});
			}	
		}
		
		select(new ArrayList<int[]>(), 0);
		
		System.out.println(mini);
	}
}
