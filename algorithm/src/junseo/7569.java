package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayDeque<int []> tomato;
	static int N,M,H;
	static int[][][] map;
	static int[] dx = {0,0,-1,1,0,0};//앞뒤상하좌우
	static int[] dy = {0,0,0,0,-1,1};
	static int[] dh = {-1,1,0,0,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new ArrayDeque<>();
		map = new int[H][N][M];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if (map[k][i][j] == 1) {
						tomato.add(new int[] {k, i, j });
					}
				}
			}
		}
		int cnt = 0;
		if(tomato.size() == N*M*H) System.out.println(0);
		else {
			cnt = bfs();
			System.out.println(cnt);
		}

	}

	private static int bfs() {
		int cnt = -1;
		while(!tomato.isEmpty()) {
			int size = tomato.size();
			cnt++;
			for (int j = 0; j < size; j++) {
			
				int cur[] = tomato.poll();
				int h = cur[0];
				int x = cur[1];
				int y = cur[2];

				for (int i = 0; i < 6; i++) {
					int nh = h + dh[i];
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || nh<0 || nh>=H)
						continue;
					if (map[nh][nx][ny] != 0)
						continue;
					map[nh][nx][ny] = 1;
					tomato.add(new int[] { nh,nx,ny });
				}
			}
		}
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] == 0) {
						cnt = -1;
						break;
					}
				}
			}
		}
		return cnt;	
	}
}



