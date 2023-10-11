package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b7576 {
	
	static ArrayDeque<int []> tomato;
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};//상하좌우
	static int[] dy = {0,0,-1,1};//상하좌우
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new ArrayDeque<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					tomato.add(new int[] {i,j});
				}
			}
		}
		int cnt = 0;
		if(tomato.size() == N*M) System.out.println(0);
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
				int x = cur[0];
				int y = cur[1];

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (map[nx][ny] != 0)
						continue;
					map[nx][ny] = 1;
					tomato.add(new int[] { nx, ny });
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					cnt = -1;
					break;
				}
			}
		}
		
		return cnt;
		
	}

}





