package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b23288 {
	public static int[][] dr = new int[][] {{0,1,0,-1}, {1,0,-1,0}};
	public static int n;
	public static int m;
	public static int[][] pan;
	public static int result = 0;
	
	public static class dice {
		static int up = 1;
		static int north = 2;
		static int east = 3;
		static int south = 5;
		static int west = 4;
		static int down = 6;
		
		static int y = 0;
		static int x = 0;
		
		static int direc = 0;
	}
	
	public static boolean isOut(int y, int x) {
		if (y < 0 || y >= n) return true;
		if (x < 0 || x >= m) return true;
		return false;
	}
	
	public static void rollDice() {
		if (dice.direc == 0 && isOut(dice.y, dice.x+1)) dice.direc = 2;
		if (dice.direc == 1 && isOut(dice.y+1, dice.x)) dice.direc = 3;
		if (dice.direc == 2 && isOut(dice.y, dice.x-1)) dice.direc = 0;
		if (dice.direc == 3 && isOut(dice.y-1, dice.x)) dice.direc = 1;
		
		
		if (dice.direc == 0) {
			dice.x++;
			
			int temp = dice.up;
			dice.up = dice.west;
			dice.west = dice.down;
			dice.down = dice.east;
			dice.east = temp;
		} else if (dice.direc == 1) {
			dice.y++;
			
			int temp = dice.up;
			dice.up = dice.north;
			dice.north = dice.down;
			dice.down = dice.south;
			dice.south = temp;
		} else if (dice.direc == 2) {
			dice.x--;
			
			int temp = dice.up;
			dice.up = dice.east;
			dice.east = dice.down;
			dice.down = dice.west;
			dice.west = temp;
		} else {
			dice.y--;
			
			int temp = dice.up;
			dice.up = dice.south;
			dice.south = dice.down;
			dice.down = dice.north;
			dice.north = temp;
		}
	}
	
	public static void scoreCal() {
		int pSco = pan[dice.y][dice.x];
		if (dice.down > pSco) dice.direc = (dice.direc + 1) % 4;
		else if (dice.down < pSco) dice.direc = (dice.direc + 3) % 4;
		
		Queue<int[]> que = new LinkedList<int[]>();
		boolean[][] visit = new boolean[n][m];
		que.add(new int[] {dice.y, dice.x});
		visit[dice.y][dice.x] = true;
		int cnt = 1;
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int i = 0; i < 4; i++) {
				int goy = now[0] + dr[0][i];
				int gox = now[1] + dr[1][i];
				if (isOut(goy, gox) || pan[goy][gox] != pSco || visit[goy][gox]) continue;
				visit[goy][gox] = true;
				que.add(new int[] {goy, gox});
				cnt++;
			}
		}
		
		result += cnt * pSco;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/*
		 * 1. 이동방향으로 한칸(끝칸이라면 이동방향 반대로 바꾼 후 한칸)
		 * 2. 도착한 칸 점수(B*주변에B영역크기) 획득
		 * 3. 주사위 아랫면 A 칸 B
		 * 	A>B 시계, A=B 변화 x, A<B 반시계 
		 */
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); // 이동 횟수
		
		pan = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int idong = 0; idong < k; idong++) {
			rollDice();
			scoreCal();
		}
		
		System.out.println(result);
	}
}
