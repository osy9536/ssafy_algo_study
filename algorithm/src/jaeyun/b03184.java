package algorithm.src.jaeyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b03184 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int[] dx = {-1, 1, 0, 0};
		final int[] dy = {0, 0, -1, 1};
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sheep = 0, wolf = 0;
		boolean[][] visited = new boolean[N][M];
		char[][] map = new char[N][M+1];
		for (int i=0; i<N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = tmp[j];
				if (map[i][j] == '#') {
					visited[i][j] = true;
				}
				else if (map[i][j] == 'o') {
					sheep++;
				}
				else if (map[i][j] == 'v') {
					wolf++;
				}
			}
		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (visited[i][j]) continue;
				
				int sheep_cnt = 0; int wolf_cnt = 0;
				Queue<Pair> q = new LinkedList<>();
				q.add(new Pair(i, j));
				visited[i][j] = true;
				while (!q.isEmpty()) {
					int size = q.size();
					for (int t=0; t<size; t++) {
						Pair pop = q.poll();
						if (map[pop.x][pop.y] == 'o') sheep_cnt++;
						else if (map[pop.x][pop.y] == 'v') wolf_cnt++;
						for (int d=0; d<4; d++) {
							int nx = pop.x + dx[d];
							int ny = pop.y + dy[d];
							if (nx<0 || ny<0 || nx>=N || ny>=M) continue;
							if (!visited[nx][ny]) {
								visited[nx][ny] = true;
								q.add(new Pair(nx, ny));
							}
						}
					}
				}
				if (wolf_cnt < sheep_cnt) wolf = wolf - wolf_cnt;
				else sheep = sheep - sheep_cnt;
			}
		}
		System.out.println(sheep+" "+wolf);
	}
}

class Pair {
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
