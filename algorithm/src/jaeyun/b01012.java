package algorithm.src.jaeyun;

import java.util.*;
import java.io.*;

public class b01012 {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[M][N];
			for (int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int tmpx = Integer.parseInt(st.nextToken());
				int tmpy = Integer.parseInt(st.nextToken());
				map[tmpx][tmpy] = 1;
			}
			
			int ans = 0;
			for (int x=0; x<M; x++) {
				for (int y=0; y<N; y++) {
					if (map[x][y] == 0) continue;
					
					Queue<Pair> q = new LinkedList<>();
					q.add(new Pair(x, y));
					map[x][y] = 0; // apply visited
					while (!q.isEmpty()) {
						Pair pair = q.poll();
						
						for (int d=0; d<4; d++) {
							int nx = pair.x + dx[d];
							int ny = pair.y + dy[d];
							if (nx<0 || ny<0 || nx>M-1 || ny>N-1) continue;
							if (map[nx][ny] == 1) {
								q.add(new Pair(nx, ny));
								map[nx][ny] = 0;
							}
						}
					}
					ans += 1;
				}
			}
			System.out.println(ans);
		}
	}
	
	static private class Pair {
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
