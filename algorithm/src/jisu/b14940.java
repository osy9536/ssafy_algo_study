package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14940 { 
	static int n;
	static int m;
	
	static int[][] zido;
	
	static int[][] dr = new int[][] {{0,1,0,-1}, {1,0,-1,0}};
	
	public static boolean isOut(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= m;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		int[] start = new int[2];
		int[][] visit = new int[n][m];
		
		zido = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				zido[i][j] = Integer.parseInt(st.nextToken());
				if (zido[i][j] == 2) {
					start = new int[] {i,j};
					visit[i][j] = -2;
				} else if (zido[i][j] == 0) visit[i][j] = -2;
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		Queue<Integer> cntque = new LinkedList<>();
		que.add(start);
		cntque.add(0);
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			int cnt = cntque.poll();
			for (int i = 0; i < 4; i++) {
				int y = now[0] + dr[0][i];
				int x = now[1] + dr[1][i];
				if (isOut(y,x) || visit[y][x] != 0) continue;
				que.add(new int[] {y,x});
				cntque.add(cnt+1);
				visit[y][x] = cnt+1;
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a = visit[i][j];
				if (a == -2) System.out.print(0 + " ");
				else if (a == 0) System.out.print(-1 + " ");
				else System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}

