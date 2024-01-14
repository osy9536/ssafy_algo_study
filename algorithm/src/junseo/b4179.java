package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b4179 {
	
	static int R,C;
	static char[][] map;
	static int[] dx = {-1,1,0,0};//상하좌우
	static int[] dy = {0,0,-1,1}; 
	static	ArrayDeque<int[]> fire;
	static	ArrayDeque<int[]> jihun;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
				
		map = new char[R][C];
		
		fire = new ArrayDeque<>();
		jihun = new ArrayDeque<>();
		
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') jihun.add(new int[] {i,j});
				if(map[i][j] == 'F') fire.add(new int[] {i,j});
			}
		}
		
		cnt = bfs();
		if(cnt == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(cnt);
		
	}


	private static int bfs() {

		int cnt = 0;
		boolean flag = false;
		while (!jihun.isEmpty()) {
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
					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					if (map[nx][ny] == '#' || map[nx][ny] == 'F')
						continue;

					map[nx][ny] = 'F';
					fire.add(new int[] { nx, ny });

				}
			}

			size = jihun.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				if(flag) break;
				int cur[] = jihun.poll();
				int x = cur[0];
				int y = cur[1];

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
						flag = true;
						break;
					}
						
					if (map[nx][ny] == '#' || map[nx][ny] == 'F' || map[nx][ny] == 'J')
						continue;
					map[nx][ny] = 'J';
					jihun.add(new int[] { nx, ny });

				}
			}
		}
		if(jihun.isEmpty() && !flag) cnt = -1;
		return cnt;
	}


	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
	}

}



