package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Locate {
	int x, y, cnt, wall;

	public Locate(int x, int y, int cnt, int wall) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.wall = wall;
	}
}

public class b2206 {

	static int N, M;
	static int[][] map;
	static boolean[][][] isVisited;
	static int count = 0;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static int BFS() {

		Queue<Locate> q = new ArrayDeque<>();
		q.add(new Locate(0, 0, 1, 0));
		isVisited[0][0][0]= true;
		isVisited[1][0][0]= true;
		while (!q.isEmpty()) {
			Locate l = q.poll();
			if(l.x==N-1 && l.y==M-1) return l.cnt;
			for (int d = 0; d < 4; d++) {
				int x1 = dx[d] + l.x;
				int y1 = dy[d] + l.y;
				if (x1 >= 0 && x1 < N && y1 >= 0 && y1 < M) {
					if (map[x1][y1] == 0) {
						if (isVisited[l.wall][x1][y1] == false) {
							q.add(new Locate(x1, y1, l.cnt + 1, l.wall));
							isVisited[l.wall][x1][y1] = true;
						}
					}
					else if (map[x1][y1] == 1) {
						if (l.wall == 0 && isVisited[1][x1][y1] == false) {
							q.add(new Locate(x1, y1, l.cnt + 1,1));
							isVisited[1][x1][y1] = true;
						}
					}
				}

			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isVisited = new boolean[2][N][M];

		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		System.out.println(BFS());
	}
}
/*
 * 6 4 0100 1110 1000 0000 0111 0000
 */