package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class lo {
	int x, y, z;

	public lo(int z, int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class b7569 {
	static int N, M, H, count = 0;
	static int[][][] map;
	static boolean[][][] isVisited;
	static int[][] d = { { 0, -1, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static boolean check() {
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[h][n][m] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void BFS() {
		Queue<lo> q = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[h][n][m] == 1) {
						q.add(new lo(h , n, m));
					}
				}
			}
		}
		while (!q.isEmpty()) {
			int qsize = q.size();
			count++;
			for (int l = 0; l < qsize; l++) {
				lo p = q.poll();
				isVisited[p.z][p.x][p.y] = true;
				for (int i = 0; i < 6; i++) {
					int a = p.x + d[i][0];
					int b = p.y + d[i][1];
					int c = p.z + d[i][2];
					
					if (a < 0 || a >= N || b < 0 || b >= M || c < 0 || c >= H)
						continue;
					if (!isVisited[c][a][b] && map[c][a][b] == 0 && map[c][a][b] != -1) {
						q.add(new lo(c, a, b));
						map[c][a][b] = 1;
						isVisited[c][a][b] = true;
					}
					
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		isVisited = new boolean[H][N][M];
		map = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		// 입력 끝
		if (check()) {
			System.out.print(0);
			
		}
		else {
			BFS();
			if (!check())
				System.out.println(-1);
			else {
				System.out.println(count-1);
			}
		}
	}
}
