package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b2210 {
	static int[][] arr = new int[5][5];
	static Set<Integer> set = new HashSet<>();
	static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
	static boolean[][] visit = new boolean[5][5];
	
	static boolean isOut(int y, int x) {
		return y < 0 || y >= 5 || x < 0 || x >= 5;
	}
	
	static void dfs(int y, int x, int cnt, int num) {
		if (cnt <= -1) {
			set.add(num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int w = y + dr[0][i];
			int v = x + dr[1][i];
			if (isOut(w,v)) continue;
			int reNum = num + arr[w][v] * (int) Math.pow(10, cnt);
			dfs(w, v, cnt-1, reNum);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				dfs(i, j, 4, arr[i][j] * (int) Math.pow(10, 5));
			}
		}
		
		System.out.println(set.size());
	}
}
