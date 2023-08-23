package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b10026 {

	static int N;
	static char[][] arr;
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		//print();
		visited = new boolean[N][N];
		nomal();
		visited = new boolean[N][N];
		redGreen();

		System.out.println(sb);
	}

	private static void nomal() {
		Queue<int []> queue = new ArrayDeque<>();
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				else {
					res++;
					queue.offer(new int[] {i,j});
					while (!queue.isEmpty()) {
						int[] temp = queue.poll();
						int idx = 0;
						int x = temp[0];
						int y = temp[1];
						while (idx < 4) {
							int nx = x + dx[idx];
							int ny = y + dy[idx];
							if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == arr[x][y] && !visited[nx][ny]) {
								queue.offer(new int[] { nx, ny });
								visited[nx][ny] = true;
							}
							idx++;
						}
					}
				}
			}
		}
		sb.append(res).append(" ");
	}

	private static void redGreen() {
		Queue<int []> queue = new ArrayDeque<>();
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				else {
					res++;
					queue.offer(new int[] {i,j});
					while (!queue.isEmpty()) {
						int[] temp = queue.poll();
						int idx = 0;
						int x = temp[0];
						int y = temp[1];
						while (idx < 4) {
							int nx = x + dx[idx];
							int ny = y + dy[idx];
							if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
								if((arr[nx][ny] == arr[x][y])||((arr[nx][ny] == 'R')&&(arr[x][y] == 'G')) ||((arr[nx][ny] == 'G')&&(arr[x][y] == 'R'))) {
									queue.offer(new int[] { nx, ny });
									visited[nx][ny] = true;
								}
							}
							idx++;
						}
					}
				}
			}
		}
		sb.append(res);
	}


	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}

