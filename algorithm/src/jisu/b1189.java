package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1189 {
	static int r,c,k,result;
	static boolean[][] visit;
	static String[] map;
	static int[][] dr = {{0,1,0,-1},{1,0,-1,0}};
	static boolean isOut(int y, int x) {
		return y < 0 || y >= r || x < 0 || x >= c;
	}
	static boolean arrived(int y, int x) {
		return y == 0 && x == c-1;
	}
	static void back(int y, int x, int cnt) {
		if (cnt == k) {
			if (arrived(y,x)) {
				result++;
			}
			return;
		}
		if (arrived(y,x)) return;
		
		for (int i = 0; i < 4; i++) {
			int w = y + dr[0][i];
			int v = x + dr[1][i];
			if (isOut(w,v) || visit[w][v] || map[w].charAt(v) == 'T') continue;
			visit[w][v] = true;
			back(w,v,cnt+1);
			visit[w][v] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visit = new boolean[r][c];
		map = new String[r];
		
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine();
		}
		
		visit[r-1][0] = true;
		back(r-1,0,1);
		
		System.out.println(result);
	}
}
