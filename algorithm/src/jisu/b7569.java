package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7569 {
	public static boolean isin(int[] xyz, int h, int n, int m) {
		if (xyz[0] < 0 || xyz[0] >= h) return false;
		if (xyz[1] < 0 || xyz[1] >= n) return false;
		if (xyz[2] < 0 || xyz[2] >= m) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 가로 세로 높이
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][][] tomato = new int[h][n][m];
		int atcnt = 0; // 전체 토마토 개수
		int ikcnt = 0; // 익은 토마토 개수
		
		Queue<int[]> que = new LinkedList<int[]>();
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomato[i][j][k] != -1) {
						atcnt++;
						if (tomato[i][j][k] == 1) {
							ikcnt++;
							que.add(new int[] {i, j, k, 0});
						}
					}
				}
			}
		}
		
		int[][] dr = {{0,0,0,0,1,-1}, {0, 1, 0, -1, 0, 0}, {1, 0, -1, 0, 0, 0}};//우하좌상위아래
		
		
		int result = 0;
		
		while (que.size() != 0 && atcnt != ikcnt) {
			int[] now = que.poll();
			for (int i = 0; i < 6; i++) {
				int z = now[0] + dr[0][i];
				int y = now[1] + dr[1][i];
				int x = now[2] + dr[2][i];
				if (isin(new int[] {z, y, x}, h, n, m) && tomato[z][y][x] == 0) {
					tomato[z][y][x] = 1;
					que.add(new int[] {z,y,x, now[3]+1});
					ikcnt++;
					if (result < now[3]+1) result = now[3]+1;
				}
			}
		}
		
		if (atcnt != ikcnt) result = -1;
		System.out.println(result);
	}
}

