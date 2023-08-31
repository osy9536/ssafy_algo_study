package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 감시
// gold4
public class b15683 {
	private static class CCTV {
		int num;
		int x, y;

		CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map, copyMap;
	static boolean[][] visited;
	static int[] num;
	static List<CCTV> list;
	static int answer = Integer.MAX_VALUE, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if (a > 0 && a < 6) {
					list.add(new CCTV(a, i, j));
				}
			}
		}
		num = new int[list.size()];

		permutation(0, list.size());

		System.out.println(answer);
	}

	private static void permutation(int depth, int size) {
		if (depth == size) {
			for (int i = 0; i < map.length; i++) {
				copyMap[i] = map[i].clone();
			}
			for (int i = 0; i < list.size(); i++) {
				CCTV c = new CCTV(list.get(i).num,list.get(i).x,list.get(i).y);
				dfs(c, num[i]);
			}

			int cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (copyMap[i][j] == 0) {
						cnt++;
					}
				}
			}
			answer = Math.min(answer, cnt);
			return;
		}
		for (int i = 0; i < 4; i++) {
			num[depth] = i;
			permutation(depth + 1, size);
		}
	}

	private static void dfs(CCTV cctv, int dir) {
		int n = cctv.num;
		int x = cctv.x;
		int y = cctv.y;
		if (n == 1) {
			cctv(x,y,dir);
		} else if (n == 2) {
			cctv(x,y,dir);
			cctv(x,y,(dir+2)%4);
		} else if (n == 3) {
			cctv(x,y,dir);
			cctv(x,y,(dir+1)%4);
		} else if (n == 4) {
			cctv(x,y,(dir+3)%4);
			cctv(x,y,dir);
			cctv(x,y,(dir+1)%4);
		} else if (n == 5) {
			cctv(x,y,dir);
			cctv(x,y,(dir+1)%4);
			cctv(x,y,(dir+2)%4);
			cctv(x,y,(dir+3)%4);
		}
	}
	private static void cctv(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx >= 0 && nx < N && ny >= 0 && ny < M && copyMap[nx][ny] != 6) {
			if(copyMap[nx][ny]==0)
				copyMap[nx][ny] = -1;
			cctv(nx,ny, dir);
		}
	}
}
