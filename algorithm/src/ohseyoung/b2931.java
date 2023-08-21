package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가스관
// gold3
public class b2931 {
	static String[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int R, C;
	static boolean[][] visited;
	static StringBuilder sb;
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		visited = new boolean[R][C];
		check = false;
		sb = new StringBuilder();
		int[] m = new int[2];
		int[] z = new int[2];
		for (int i = 0; i < R; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = s[j];
				if (s[j].equals("M")) {
					m[0] = i;
					m[1] = j;
				}
				if (s[j].equals("Z")) {
					z[0] = i;
					z[1] = j;
				}
			}
		}
		// M 또는 Z 근처에서 "."이 아닌 블록이 존재하면 dfs 시작
		for (int i = 0; i < 4; i++) {
			int nx = m[0] + dx[i];
			int ny = m[1] + dy[i];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
				if (!map[nx][ny].equals(".")) {
					visited[m[0]][m[1]] = true;
					dfs(nx, ny);
				}
			}
			// M바로 옆이 .일경우 위에서 처리 불가 -> Z부터 시작
			if (sb.length() < 6) {
				int nx1 = z[0] + dx[i];
				int ny1 = z[1] + dy[i];
				if (nx1 >= 0 && ny1 >= 0 && nx1 < R && ny1 < C) {
					if (!map[nx1][ny1].equals(".")) {
						visited[m[0]][m[1]] = true;
						dfs(nx1, ny1);
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

	// "."나올때까지 반복
	static void dfs(int x, int y) {
		if (check) {
			return;
		}
		if (!visited[x][y]) {
			// 방문처리
			visited[x][y] = true;

			// 각 블록별 dfs 처리
			if (map[x][y].equals("|")) {
				dfs(x + dx[0], y + dy[0]);
				dfs(x + dx[2], y + dy[2]);
			} else if (map[x][y].equals("-")) {
				dfs(x + dx[1], y + dy[1]);
				dfs(x + dx[3], y + dy[3]);
			} else if (map[x][y].equals("+")) {
				dfs(x + dx[0], y + dy[0]);
				dfs(x + dx[1], y + dy[1]);
				dfs(x + dx[2], y + dy[2]);
				dfs(x + dx[3], y + dy[3]);
			} else if (map[x][y].equals("1")) {
				dfs(x + dx[1], y + dy[1]);
				dfs(x + dx[2], y + dy[2]);
			} else if (map[x][y].equals("2")) {
				dfs(x + dx[0], y + dy[0]);
				dfs(x + dx[1], y + dy[1]);
			} else if (map[x][y].equals("3")) {
				dfs(x + dx[0], y + dy[0]);
				dfs(x + dx[3], y + dy[3]);
			} else if (map[x][y].equals("4")) {
				dfs(x + dx[2], y + dy[2]);
				dfs(x + dx[3], y + dy[3]);
			} else if (map[x][y].equals(".")) {
				sb.append((x + 1) + " " + (y + 1) + " ");
				solve(x, y);
			}

		}

	}

	static void solve(int x, int y) {
		// 상 우 하 좌 순으로 연결 되었는지 확인
		boolean[] isConnect = new boolean[4];
		int upX = x + dx[0];
		int upY = y + dy[0];
		int rightX = x + dx[1];
		int rightY = y + dy[1];
		int downX = x + dx[2];
		int downY = y + dy[2];
		int leftX = x + dx[3];
		int leftY = y + dy[3];
		// 상 연결 확인
		if ((x + dx[0] >= 0 && x + dx[0] < R && y + dy[0] >= 0 && y + dy[0] < C) && (map[upX][upY].equals("|")
				|| map[upX][upY].equals("+") || map[upX][upY].equals("1") || map[upX][upY].equals("4"))) {
			isConnect[0] = true;
		}
		// 우 연결 확인
		if ((x + dx[1] >= 0 && x + dx[1] < R && y + dy[1] >= 0 && y + dy[1] < C)
				&& (map[rightX][rightY].equals("-") || map[rightX][rightY].equals("+")
						|| map[rightX][rightY].equals("3") || map[rightX][rightY].equals("4"))) {
			isConnect[1] = true;
		}
		// 하 연결 확인
		if ((x + dx[2] >= 0 && x + dx[2] < R && y + dy[2] >= 0 && y + dy[2] < C) && (map[downX][downY].equals("|")
				|| map[downX][downY].equals("+") || map[downX][downY].equals("2") || map[downX][downY].equals("3"))) {
			isConnect[2] = true;
		}
		// 좌 연결 확인
		if ((x + dx[3] >= 0 && x + dx[3] < R && y + dy[3] >= 0 && y + dy[3] < C) && (map[leftX][leftY].equals("-")
				|| map[leftX][leftY].equals("+") || map[leftX][leftY].equals("1") || map[leftX][leftY].equals("2"))) {
			isConnect[3] = true;
		}
		// 상우 연결인지
		if (isConnect[0] && isConnect[1] && !isConnect[2] && !isConnect[3]) {
			sb.append("2");
		}
		// 상하 연결인지
		if (isConnect[0] && isConnect[2] && !isConnect[1] && !isConnect[3]) {
			sb.append("|");
		}
		// 상좌 연결인지
		if (isConnect[0] && isConnect[3] && !isConnect[1] && !isConnect[2]) {
			sb.append("3");
		}
		// 우하 연결인지
		if (isConnect[1] && isConnect[2] && !isConnect[0] && !isConnect[3]) {
			sb.append("1");
		}
		// 우좌 연결인지
		if (isConnect[1] && isConnect[3] && !isConnect[0] && !isConnect[2]) {
			sb.append("-");
		}
		// 하좌 연결인지
		if (isConnect[2] && isConnect[3] && !isConnect[0] && !isConnect[1]) {
			sb.append("4");
		}
		// 상우하좌 연결인지
		if (isConnect[0] && isConnect[1] && isConnect[2] && isConnect[3]) {
			sb.append("+");
		}
	}
}
