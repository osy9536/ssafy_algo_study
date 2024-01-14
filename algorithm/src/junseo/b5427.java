package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int w, h;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };// 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayDeque<int[]> fire;
	static ArrayDeque<int[]> sangn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new char[h][w];

			fire = new ArrayDeque<>();
			sangn = new ArrayDeque<>();

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@')
						sangn.add(new int[] { i, j });
					if (map[i][j] == '*')
						fire.add(new int[] { i, j });
				}
			}

			cnt = bfs();
			if (cnt == -1)
				sb.append("IMPOSSIBLE").append("\n");
			else
				sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs() {

		int cnt = 0;
		boolean flag = false;
		while (!sangn.isEmpty()) {
			if(flag) break;
			//print();
			int size = fire.size();
			for (int i = 0; i < size; i++) {
				int cur[] = fire.poll();
				int x = cur[0];
				int y = cur[1];

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w)
						continue;
					if (map[nx][ny] == '#' || map[nx][ny] == '*')
						continue;

					map[nx][ny] = '*';
					fire.add(new int[] { nx, ny });

				}
			}

			size = sangn.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				if(flag) break;
				int cur[] = sangn.poll();
				int x = cur[0];
				int y = cur[1];

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
						flag = true;
						break;
					}
						
					if (map[nx][ny] == '#' || map[nx][ny] == '*' || map[nx][ny] == '@')
						continue;
					map[nx][ny] = '@';
					sangn.add(new int[] { nx, ny });

				}
			}
		}
		if(sangn.isEmpty() && !flag) cnt = -1;
		return cnt;
	}


	private static void print() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
	}

}


