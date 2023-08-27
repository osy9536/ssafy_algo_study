package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class b07562 {
	static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] start = new int[2];
			int[] end = new int[2];
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
//			System.out.println(Arrays.toString(start)+"   "+Arrays.toString(end));
			
			Queue<Pair> q = new ArrayDeque<>();
			boolean[][] visited = new boolean[N][N];
			q.add(new Pair(start[0], start[1]));
			visited[start[0]][start[1]] = true;
			boolean found = false;
			int ans = 0;
			while (!q.isEmpty()) {
				int qsize = q.size();
				for (int i=0; i<qsize; i++) {
					Pair pair = q.poll();
					if (pair.x == end[0] && pair.y == end[1]) {
						found = true;
						break;
					}
					for (int d=0; d<8; d++) {
						int nx = pair.x + dx[d];
						int ny = pair.y + dy[d];
						if (nx<0 || ny<0 || nx>N-1 || ny>N-1) continue;
						if (visited[nx][ny]) continue;
						q.add(new Pair(nx, ny));
						visited[nx][ny] = true;
					}
				}
				if (found) break;
				ans += 1;
			}
//			System.out.println("#"+tc+" "+ans);
//			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	private static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
