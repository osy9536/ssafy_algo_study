package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b21736 { 
	static int n;
	static int m;
	static String[] campus;
	static int mini = Integer.MAX_VALUE;
	
	static int[][] dr = new int[][] {{0,1,0,-1}, {1,0,-1,0}};
	
	public static boolean isOut(int y, int x) {
		if (y < 0 || y >= n || x < 0 || x >= m) return true;
		return false;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		campus = new String[n];
		int[] start = new int[2];
		
		for (int i = 0; i < n; i++) {
			campus[i] = br.readLine();
			for (int j = 0; j < m; j++) {
				if (campus[i].charAt(j) == 'I') start = new int[] {i,j};
			}
		}
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(start);
		boolean[][] visit = new boolean[n][m];
		visit[start[0]][start[1]] = true;
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			if (campus[now[0]].charAt(now[1]) == 'P') result++;
			for (int i = 0; i < 4; i++) {
				int y = now[0] + dr[0][i];
				int x = now[1] + dr[1][i];
				if (isOut(y,x) || visit[y][x] || campus[y].charAt(x) == 'X') continue;
				
				que.add(new int[] {y,x});
				visit[y][x] = true;
			}
		}
		
		if (result == 0) System.out.println("TT");
		else System.out.println(result);
		
	}
}