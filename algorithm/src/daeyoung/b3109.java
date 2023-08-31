package algorithm.src.daeyoung;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 3109
 * 빵집
 * 골드2
 * https://www.acmicpc.net/problem/3109
 */
public class b3109 {
	static String[][] map;
	static int cnt = 0;
	static int flag = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		map = new String[r][c];
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().split("");
		}
		
		for(int i = 0; i < map.length; i++) {
			flag = 0;
			findRoot(i, 0);
		}
		
		System.out.println(cnt);
	}
	
	public static void findRoot(int r, int c) {
		if(c == map[0].length - 1) {
			cnt++;
			flag = 1;
			return;
		}
		
		//오른 위 대각
		if(flag == 0 && r - 1 >= 0) {
			if(map[r - 1][c + 1].equals(".")) {
				map[r - 1][c + 1] = "O";
				findRoot(r - 1, c + 1);
			}
			
		}
		
		
		//오른쪽
	
		if(flag == 0 && map[r][c + 1].equals(".")) {
			map[r][c + 1] = "O";
			findRoot(r, c + 1);
		}
		
		
		//오른 아래 대각
		if(flag == 0 && r + 1 < map.length) {
			if(map[r + 1][c + 1].equals(".")) {
				map[r + 1][c + 1] = "O";
				findRoot(r + 1, c + 1);
			}
			
		}
		
		
	}
}
