package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 10026
 * 적록색약
 * 골드5
 * https://www.acmicpc.net/problem/10026
 */
public class b10026 {
	static int n;
	static char[][] area;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, 1, -1, 0};
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		area = new char[n][n];
		for(int i = 0; i < n; i++) {
			area[i] = br.readLine().toCharArray();
		}
		
		//정상
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.print(count +" ");
		
		//적록색약
		rgSame();
		visited = new boolean[n][n];
		count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.println(count);

	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		char cur = area[x][y];
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) 
				continue;
			
			if(!visited[nextX][nextY] && area[nextX][nextY] == cur)
				dfs(nextX, nextY);
		}
		
		
	}
	
	public static void rgSame() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(area[i][j] == 'R')
					area[i][j] = 'G';
			}
		}
	}
}
