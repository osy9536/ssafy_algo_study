package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 캐슬 디펜스
// gold 3
public class b17135 {
	static int[][] map, mapCopy;
	static int N, M, D, cnt, answer;
	static int[] arc;
	static boolean[][] visited1, visited2, visited3;
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };
	static boolean[] comVisited;
	static int[] com = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapCopy = new int[N][M];
		visited1 = new boolean[N][M];
		visited2 = new boolean[N][M];
		visited3 = new boolean[N][M];
		arc = new int[M];
		comVisited = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				mapCopy[i][j] = a;
			}
		}

		combination(0, M, 0);
		System.out.println(answer);
	}

	// 0 0 0 0 0
	// 0 0 0 0 0
	// 0 0 0 0 0
	// 0 0 0 0 0
	// 0 0 1 0 0
	// 0 1 0 1 1
	// depth = 0
	static void bfs(int x1, int y1, int x2, int y2, int x3, int y3) {
		Queue<Point> q1 = new LinkedList<>();
		Queue<Point> q2 = new LinkedList<>();
		Queue<Point> q3 = new LinkedList<>();
		q1.add(new Point(x1, y1,0));
		q2.add(new Point(x2, y2,0));
		q3.add(new Point(x3, y3,0));
		while (!q1.isEmpty()) {
			
			int xx1 = q1.peek().x;
			int yy1 = q1.peek().y;
			int depth = q1.poll().depth;
			if (depth == D)
				break;
			if (!visited1[xx1][yy1]) {
				visited1[xx1][yy1] = true;
				if (map[xx1][yy1] == 1) {
					map[xx1][yy1] = 10;
					break;
				}
				for (int i = 0; i < 3; i++) {
					int nx = xx1 + dx[i];
					int ny = yy1 + dy[i];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited1[nx][ny]) {
						q1.add(new Point(nx, ny,depth+1));
					}
				}
			}
		}
		while (!q2.isEmpty()) {
			int xx1 = q2.peek().x;
			int yy1 = q2.peek().y;
			int depth = q2.poll().depth;
			if (depth == D)
				break;
			if (!visited2[xx1][yy1]) {
				visited2[xx1][yy1] = true;
				if (map[xx1][yy1] == 1 || map[xx1][yy1] == 10) {
					map[xx1][yy1] = 11;
					break;
				}
				for (int i = 0; i < 3; i++) {
					int nx = xx1 + dx[i];
					int ny = yy1 + dy[i];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited2[nx][ny]) {
						q2.add(new Point(nx, ny,depth+1));
					}
				}
			}
		}
		while (!q3.isEmpty()) {
			int xx1 = q3.peek().x;
			int yy1 = q3.peek().y;
			int depth = q3.poll().depth;
			if (depth == D)
				break;
			if (!visited3[xx1][yy1]) {
				visited3[xx1][yy1] = true;
				if (map[xx1][yy1] == 1 || map[xx1][yy1] == 10 || map[xx1][yy1] == 11) {
					map[xx1][yy1] = (depth+1)*12;
					break;
				}
				for (int i = 0; i < 3; i++) {
					int nx = xx1 + dx[i];
					int ny = yy1 + dy[i];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited3[nx][ny]) {
						q3.add(new Point(nx, ny,depth+1));
					}
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j]>1) {
					map[i][j] = 0;
					cnt++;
				}
			}
		}

	}

	static void kill(int y1, int y2, int y3) {
		for (int i = N - 1; i >= 0; i--) {
			bfs(i, y1, i, y2, i, y3);
//			System.out.println(cnt);
			visited1 = new boolean[N][M];
			visited2 = new boolean[N][M];
			visited3 = new boolean[N][M];
		}
	}

	static void combination(int start, int m, int r) {
		if (r == 3) {
			kill(com[0], com[1], com[2]);
			if (cnt > answer) {
				answer = cnt;
			}
			cnt = 0;
			for (int i = 0; i < N; i++) {
				map[i] = mapCopy[i].clone();
			}
			return;
		}
		for (int i = start; i < m; i++) {
			comVisited[i] = true;
			com[r] = i;
			combination(i + 1, m, r + 1);
			comVisited[i] = false;
		}

	}

	static class Point {
		int x;
		int y;
		int depth;
		
		Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth =depth;
		}
	}
}
