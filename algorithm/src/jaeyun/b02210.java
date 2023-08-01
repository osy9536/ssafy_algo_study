package algorithm.src.jaeyun;

import java.util.ArrayList;
import java.util.Scanner;

public class b02210 {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	static ArrayList<Integer> ans;
	static int [][] map;
	public static void main(String[] args) {
		ans = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				dfs(i, j, 0, Integer.toString(map[i][j]));
			}
		}
		System.out.println(ans.size());
//		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int depth, String s) {
		if (depth == 5) {
			int r = Integer.parseInt(s);
//			if (r >= 100000 && !ans.contains(r)) ans.add(r);
			if (!ans.contains(r)) ans.add(r);
			return;
		}
		for (int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx<0 || ny<0 || nx>4 || ny>4) continue;
			dfs(nx, ny, depth+1, s+Integer.toString(map[nx][ny]));
		}
	}
}
