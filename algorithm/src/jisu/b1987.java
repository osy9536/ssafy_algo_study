package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1987 {
	static int r, c;
	static int result = Integer.MIN_VALUE;
	
	static char[][] pan;
 	static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
	
	static Set<Character> set = new HashSet<>();
	
	public static boolean isOut(int y, int x) {
		return y < 0 || y >= r || x < 0 || x >= c;
	}
	
	public static void dfs(int y, int x, int cnt) {
		if (result < cnt) result = cnt;
		
		for (int i = 0; i < 4; i++) {
			int goy = y + dr[0][i];
			int gox = x + dr[1][i];
			if (isOut(goy, gox) || set.contains(pan[goy][gox])) continue;
			set.add(pan[goy][gox]);
			dfs(goy, gox, cnt+1);
			set.remove(pan[goy][gox]);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		pan = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				pan[i][j] = str.charAt(j);
			}
		}
		
		set.add(pan[0][0]);
		dfs(0,0,1);
		
		System.out.println(result);
	}
}
