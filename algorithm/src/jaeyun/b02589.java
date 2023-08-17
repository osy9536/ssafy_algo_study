package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Queue;

public class b02589 {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		char[][] map = new char[N][M];
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int ans = 0;
		for (int i1=0; i1<N; i1++) {
			for (int j1=0; j1<M; j1++) {
				if (map[i1][j1] == 'W' ) continue;
				Queue<Pair> q = new ArrayDeque<>();
				boolean[][] visited = new boolean[N][M];
				q.add(new Pair(i1, j1));
				visited[i1][j1] = true;
				int cnt = 0;
				while (!q.isEmpty()) {
					int qsize = q.size();
					for (int i=0; i<qsize; i++) {
						Pair pair = q.poll();
						for (int d=0; d<4; d++) {
							int nx = pair.x + dx[d];
							int ny = pair.y + dy[d];
							if (nx<0 || ny<0 || nx>N-1 || ny>M-1) continue;
							if (visited[nx][ny]) continue;
							if (map[nx][ny] == 'W') continue;
							q.add(new Pair(nx, ny));
							visited[nx][ny] = true;
						}
					}
					cnt += 1;
				}
				if (cnt > ans) ans = cnt;
			}
		}
		System.out.println(ans - 1);
	}
	
	private static class Pair {
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
