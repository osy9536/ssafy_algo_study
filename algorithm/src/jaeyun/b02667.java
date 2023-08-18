package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class b02667 {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Queue<Pair> q = null;
		int anscnt = 0;
		List<Integer> ansList = new ArrayList<>();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == '0') continue;
				anscnt += 1;
				q = new ArrayDeque<>();
				q.add(new Pair(i, j));
				map[i][j] = '0';
				int cnt = 1;
				while (!q.isEmpty()) {
					Pair pair = q.poll();
					for (int d=0; d<4; d++) {
						int nx = pair.x + dx[d];
						int ny = pair.y + dy[d];
						if (nx<0 || ny<0 || nx>N-1 || ny>N-1) continue;
						if (map[nx][ny] == '0') continue;
						q.add(new Pair(nx, ny));
						map[nx][ny] = '0';
						cnt += 1;
					}
				}
				ansList.add(cnt);
			}
		}
		System.out.println(anscnt);
		Collections.sort(ansList);
		for (int e: ansList) System.out.println(e);
	}
	
	private static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
