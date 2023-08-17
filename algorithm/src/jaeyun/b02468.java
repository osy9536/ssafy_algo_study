package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b02468 {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(map));
		
		Queue<Pair> q = null;
		boolean[][] visited = null;
		int ans = 0;
		for (int h=0; h<=100; h++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (visited[i][j]) continue;
					if (map[i][j] <= h) continue;
					q = new ArrayDeque<>();
					q.add(new Pair(i, j));
					visited[i][j] = true;
					while (!q.isEmpty()) {
						Pair pair = q.poll();
						for (int d=0; d<4; d++) {
							int nx = pair.x + dx[d];
							int ny = pair.y + dy[d];
							if (nx<0 || ny<0 || nx>N-1 || ny>N-1) continue;
							if (visited[nx][ny]) continue;
							if (map[nx][ny] <= h) continue;
							q.add(new Pair(nx, ny));
							visited[nx][ny] = true;
						}
					}
					cnt += 1;
				}
			}
			if (cnt > ans) ans = cnt;
//			if (cnt == 0) break;
		}
		System.out.println(ans);
	}
	
	private static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
