package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class b10026 {
	static final int[] DX = {-1, 1, 0, 0};
	static final int[] DY = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
//		System.out.println(Arrays.deepToString(map));
		
		int rgbCnt = 0;
		boolean[][] visited = new boolean[N][N];
		char curChar = '\0';
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (visited[i][j]) continue;
				Queue<Pair> rgb = new ArrayDeque<>();
				rgb.add(new Pair(i, j));
				visited[i][j] = true;
				curChar = map[i][j];
				while (!rgb.isEmpty()) {
					Pair pair = rgb.poll();
					for (int d=0; d<4; d++) {
						int nx = pair.x + DX[d];
						int ny = pair.y + DY[d];
						if (nx<0 || ny<0 || nx>N-1 || ny>N-1) continue;
						if (visited[nx][ny]) continue;
						if (map[nx][ny] == curChar) {
							rgb.add(new Pair(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
				rgbCnt += 1;
			}
		}
		
		int rrbCnt = 0;
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (visited[i][j]) continue;
				Queue<Pair> rrb = new ArrayDeque<>();
				rrb.add(new Pair(i, j));
				visited[i][j] = true;
				curChar = map[i][j] == 'G' ? 'R' : map[i][j];
				while (!rrb.isEmpty()) {
					Pair pair = rrb.poll();
					for (int d=0; d<4; d++) {
						int nx = pair.x + DX[d];
						int ny = pair.y + DY[d];
						if (nx<0 || ny<0 || nx>N-1 || ny>N-1) continue;
						if (visited[nx][ny]) continue;
						if (
								(curChar == 'R' && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) || 
								(curChar == 'B' && map[nx][ny] == 'B')
								) {
							rrb.add(new Pair(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
				rrbCnt += 1;
			}
		}
		
		System.out.println(rgbCnt+" "+rrbCnt);
		
	}
	
	private static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
