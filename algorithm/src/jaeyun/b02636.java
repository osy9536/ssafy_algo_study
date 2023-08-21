package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b02636 {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int cheeseCnt = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheeseCnt += 1;
			}
		}
		
		int ans = 0;
		int formerCheeseCnt = cheeseCnt;
		while (cheeseCnt != 0) {
			boolean[][] visited = new boolean[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (map[i][j] != 0 || visited[i][j]) continue;
					Queue<Pair> q = new ArrayDeque<>();
					boolean bordered = false;
					q.add(new Pair(i, j));
					visited[i][j] = true;
					if (i<=0 || j<=0 || i>=N-1 || j>=M-1) bordered = true;
					while (!q.isEmpty()) {
						Pair pair = q.poll();
						for (int d=0; d<4; d++) {
							int nx = pair.x + dx[d];
							int ny = pair.y + dy[d];
							if (nx<0 || ny<0 || nx>N-1 || ny>M-1) continue;
							if (visited[nx][ny] || map[nx][ny] == 1) continue;
							if (nx<=0 || ny<=0 || nx>=N-1 || ny>=M-1) bordered = true; // 끝내면 안됨, visited 배열을 다 채워야 함
							q.add(new Pair(nx, ny));
							visited[nx][ny] = true;
						}
					}
					if (!bordered) continue;
					
					boolean[][] tmpVisited = new boolean[N][M];
					q = new ArrayDeque<>();
					q.add(new Pair(i, j));
					tmpVisited[i][j] = true;
					while (!q.isEmpty()) {
						Pair pair = q.poll();
						for (int d=0; d<4; d++) {
							int nx = pair.x + dx[d];
							int ny = pair.y + dy[d];
							if (nx<0 || ny<0 || nx>N-1 || ny>M-1) continue;
							if (tmpVisited[nx][ny]) continue;
							if (map[nx][ny] == 1) {
								map[nx][ny] = 2;
								cheeseCnt -= 1;
							}
							else if (map[nx][ny] == 0) {
								q.add(new Pair(nx, ny));
								tmpVisited[nx][ny] = true;
							}
						}
					}
				}
			}
			for (int ii=0; ii<N; ii++) {
				for (int jj=0; jj<M; jj++) {
					if (map[ii][jj] == 2) map[ii][jj] = 0;
				}
			}
			ans += 1;
			if (cheeseCnt != 0) formerCheeseCnt = cheeseCnt;
		}
		System.out.println(ans+"\n"+formerCheeseCnt);
	}
	
	private static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
