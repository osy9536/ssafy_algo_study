package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b3055 {
	
	static int R,C;
	static char[][] map;
	static Queue<int []> water;
	static Queue<int []> biber;
	static int [] biberGul;
	
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	
	static int[][]cnt;
	static int res = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		cnt = new int[R][C];
		
		water = new ArrayDeque<>();
		biber = new ArrayDeque<>();
		biberGul = new int[2];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') water.add(new int[] {i,j});
				if(map[i][j] == 'D') biberGul = new int[] {i,j};
				if(map[i][j] == 'S') biber.add(new int[] {i,j});
			}
		}
		//print();
		bfs();
		if(res == -1) System.out.println("KAKTUS");
		else System.out.println(res);
	}

	private static void bfs() {
		
		while(!biber.isEmpty()) {
			int wSize = water.size();
			for (int i = 0; i < wSize; i++) {
				int[] cur = water.poll();
				int x = cur[0];
				int y = cur[1];
				for (int j = 0; j < 4; j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					if(isVaild(nx,ny)&& map[nx][ny] == '.') {
						water.add(new int[] {nx,ny});
						map[nx][ny] = '*';
					}
				}	
			}
			
			//print();
			
			int bSize = biber.size();
			for (int i = 0; i < bSize; i++) {
				int [] bcur = biber.poll();
				int bx = bcur[0];
				int by = bcur[1];
				for (int j = 0; j < 4; j++) {
					int nx = bx+dx[j];
					int ny = by+dy[j];
					if(isVaild(nx,ny) && cnt[nx][ny] == 0 && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						biber.add(new int[] {nx,ny});
						cnt[nx][ny] = cnt[bx][by]+1;
					}
				}
			}
			
			if(cnt[biberGul[0]][biberGul[1]] != 0) {
				res = cnt[biberGul[0]][biberGul[1]];
				break;
			}	
		}
		
	}

	private static boolean isVaild(int nx, int ny) {
		if(nx>=0 && nx<R && ny>=0 && ny<C) {
			return true;
		}
		return false;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.print("\n");
		}
	}
}


