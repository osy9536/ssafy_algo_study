package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b17144 {
	static int R,C,T;
	static int[][] map;
	static List<int[]> list;
	static int[] dx = {-1,1,0,0};//상하좌우
	static int[] dy = {0,0,-1,1};
	static int[] topDx = {-1,0,1,0}; //상우하좌
	static int[] topDy = {0,1,0,-1};
	static int[] botDx = {1,0,-1,0}; //하우상좌
	static int[] botDy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		st =  new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		list = new ArrayList<int[]>();
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) list.add(new int[] {i,j}); 
			}
		}
		
		//------------------------------------------------------------------
		
		for (int i = 0; i < T; i++) {
			bfs(); //확산
			clean();
		}
		//print();
		int res=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;
				res += map[i][j]; 
			}
		}
		System.out.println(res);
	}
	private static void clean() {
		
		int[] top = list.get(0);
		int x = top[0]-1;
		int y = top[1];
		int idx = 0;

		while(idx<4) {
			int nx = x + topDx[idx];
			int ny = y + topDy[idx];
			if(nx<0 || nx > top[0] || ny<0|| ny>=C || (nx == top[0] && ny==top[1])) {
				idx++;
				continue;
			}
			
			map[x][y] = map[nx][ny];
			x = nx;
			y = ny;
		}
		map[top[0]][top[1]+1] = 0;
		
		
		int[] bot = list.get(1);
		x = bot[0] + 1;
		y = bot[1];
		idx = 0;
		while(idx<4) {
			int nx = x + botDx[idx];
			int ny = y + botDy[idx];
			if(nx<bot[0] || nx >= R || ny<0|| ny>=C || (nx == top[0] && ny==top[1])) {
				idx++;
				continue;
			}
			map[x][y] = map[nx][ny];
			x = nx;
			y = ny;
		}
		map[bot[0]][bot[1]+1] = 0;

	}
	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void bfs() {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1 && map[i][j] !=0 ) {
					queue.add(new int[] {i,j,map[i][j]});
				}
			} 
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int val = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || nx>=R || ny<0 || ny>=C || map[nx][ny] == -1) continue;
				 
				map[nx][ny] += val/5;
				map[x][y] -= val/5;
				
			}
			
			
		}
		
	}

}


