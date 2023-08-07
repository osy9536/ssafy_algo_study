package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b04963 {
	static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x = 0;
		int y = 0;
		while (true) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			if (x == 0 && y == 0) break;
			
			int[][] map = new int[x][y];
			for (int i=0; i<x; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<y; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(Arrays.deepToString(map));
			int ans = 0;
			for (int i=0; i<x; i++) {
				for (int j=0; j<y; j++) {
					if (map[i][j] == 0) continue;
					Queue<Pair> q = new LinkedList<>();
					q.add(new Pair(i, j));
//					System.out.println(i + " " + j);
					map[i][j] = 0;
					while (!q.isEmpty()) {
						Pair pair = q.poll();
						for (int d=0; d<8; d++) {
							int nx = pair.x + dx[d];
							int ny = pair.y + dy[d];
							if (nx<0 || ny<0 || nx>x-1 || ny>y-1) continue;
							if (map[nx][ny] == 0) continue;
							q.add(new Pair(nx, ny));
//							System.out.println(nx + " " + ny);
							map[nx][ny] = 0;
						}
					}
					ans += 1; 
				}
			}
			System.out.println(ans);
		}
		
		
	}
	private static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
