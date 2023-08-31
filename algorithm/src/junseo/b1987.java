
package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1987_알파벳 {
	
	static boolean[] checkA = new boolean[27];
	static char[][] map;
	static int R,C;
	static int[][] cnt;
	static int[] dx = {-1,1,0,0}; //상하좌우 
	static int[] dy = {0,0,-1,1};
	static int res;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		cnt = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.println(map[i][j]);
//			}
//		}
		res= 0;
		checkA[map[0][0] -'A'] = true;
		dfs(0,0,1);
		System.out.println(res);
	}
	private static void dfs(int x, int y,int cnt) {
		
		res  = Math.max(cnt,res);
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && ny >= 0 && nx < R && ny < C && !checkA[map[nx][ny]-'A']) {
				checkA[map[nx][ny]-'A'] = true;
				dfs(nx,ny,cnt+1);
				checkA[map[nx][ny]-'A'] = false;
			}
		}
		
	}
	
}
		
		


