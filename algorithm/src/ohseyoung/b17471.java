package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1
// gold 5
public class b17471 {
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };
	static int[][] map;
	static int N, answer;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0][0] = true;
		dfs(0, 1,0);
		System.out.println(answer);
	}

	static void dfs(int x, int y, int dir) {
		if (x == N - 1 && y == N - 1) {
			answer++;
		}
		
		if (!visited[x][y]) {
			visited[x][y] = true;
			for (int i = 0; i < 3; i++) {
				if(dir==0) {
					if(i==1)continue;
				}
				if(dir==1) {
					if(i==0)continue;
				}
				int nx = x + dx[i];
				int ny = y + dy[i]; 
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 1 && !visited[nx][ny]) {
					if(i==2) {
						if(map[nx][y]!=1&&map[x][ny]!=1) {
							dfs(nx,ny,i);
						}
					}else dfs(nx, ny,i);
				}
			}
			visited[x][y] = false;
		}
	}
}
