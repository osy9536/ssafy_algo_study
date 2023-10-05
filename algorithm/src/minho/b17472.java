package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Locate {
	int x, y;

	public Locate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class MyLine implements Comparable<MyLine>{
	int from, to, value;

	public MyLine(int from, int to, int value) {
		super();
		this.from = from;
		this.to = to;
		this.value = value;
	}

	@Override
	public int compareTo(MyLine o) {
		return this.value-o.value;
	}
	
}

public class b17472 {
	static int N, M, ans = 0;
	static int[][] map, list;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean[][] isVisited;

	public static void BFS(int x, int y, int color) {
		Queue<Locate> q = new ArrayDeque<>();
		q.add(new Locate(x, y));
		map[x][y]=color;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				Locate l = q.poll();
				for (int d = 0; d < 4; d++) {
					int lx = l.x + dx[d];
					int ly = l.y + dy[d];
					if (lx >= 0 && lx < N && ly >= 0 && ly < M && map[lx][ly] == 1 && !isVisited[lx][ly]) {
						map[lx][ly] = color;
						isVisited[lx][ly] = true;
						q.add(new Locate(lx, ly));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isVisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬색칠 섬갯수 cnt;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					cnt++;
					BFS(i, j, cnt);
				}
			}
		}

		/*
		 * System.out.println("============================="); System.out.println();
		 * for (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) {
		 * System.out.print(map[i][j] + " "); } System.out.println(); }
		 */

		list = new int[cnt + 1][cnt + 1];

		// 지도상 모든다리 만들어보고 최솟값을 간선리스트에 저장
		for (int i = 0; i < N; i++) {
			int sx = 0, ck = 0;
			for (int j = 0; j < M; j++) {
				if (sx != 0 && map[i][j] == 0) {
					ck++;
				}
				if (sx == 0 && map[i][j] != 0) {
					sx = map[i][j];
				}
				if (map[i][j] != 0 && sx == map[i][j]) {
					ck=0;
				}
				if (ck > 1 && map[i][j] != 0 && sx != map[i][j]) {
					if (list[sx][map[i][j]] == 0 || ck < list[sx][map[i][j]]) {
						list[sx][map[i][j]] = ck;
						list[map[i][j]][sx] = ck;
					}
					sx = map[i][j];
					ck = 0;
				}
				else if(ck == 1 && map[i][j] != 0 && sx != map[i][j]) {
					sx = map[i][j];
					ck = 0;
				}
			}
		}
		
		for (int j = 0; j < M; j++) {
			int sx = 0, ck = 0;
			for (int i = 0; i < N; i++) {
				if (sx != 0 && map[i][j] == 0) {
					ck++;
				}
				if (sx == 0 && map[i][j] != 0) {
					sx = map[i][j];
				}
				if(map[i][j] != 0 && sx == map[i][j]) {
					ck=0;
				}
				if (ck > 1 && map[i][j] != 0 && sx != map[i][j]) {
					if (list[sx][map[i][j]] == 0 || ck < list[sx][map[i][j]]) {
						list[sx][map[i][j]] = ck;
						list[map[i][j]][sx] = ck;
					}
					sx = map[i][j];
					ck = 0;
				}
				else if(ck == 1 && map[i][j] != 0 && sx != map[i][j]) {
					sx = map[i][j];
					ck = 0;
				}
			}
		}
//======
		PriorityQueue<MyLine> q = new PriorityQueue<>();
		q.add(new MyLine(0, 1, 0));
		boolean[] visited = new boolean[cnt + 1];
		visited[0] = true;
		MyLine l;
		while (!q.isEmpty()) {
			l = q.poll();
			if (!visited[l.to]) {
				for (int i = 1; i <= cnt; i++) {
					if (list[l.to][i] != 0 && !visited[i]) {
						q.add(new MyLine(l.to, i, list[l.to][i]));
					}
				}
				ans += l.value;
				visited[l.to]=true;
			}
		}
		boolean end=true;
		for(int i = 1 ; i < cnt+1 ; i++) {
			if(!visited[i]) end = false;
				
		}
		if (!end)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}

/*

4 8
0 0 0 0 0 0 1 1
1 0 0 1 1 0 1 1
1 1 1 1 0 0 0 0
1 1 0 0 0 1 1 0
*/