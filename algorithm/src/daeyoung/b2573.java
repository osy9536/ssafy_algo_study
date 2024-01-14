package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 2573
 * 빙산
 * 골드 4
 * https://www.acmicpc.net/problem/2573
 */
public class b2573 {
	
	static class Iceberg {
		int r;
		int c;
		int size;
		
		public Iceberg(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}
	
	static int r;
	static int c;
	static int[][] ocean;
	static List<Iceberg> existance; // 현재 빙산 정보
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		ocean = new int[r][c];
		existance = new ArrayList<>();
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				ocean[i][j] = Integer.parseInt(st.nextToken());
				
				if(ocean[i][j] != 0)
					existance.add(new Iceberg(i, j, ocean[i][j]));
			}
		}
		
		int year = 0;
		int lump = 0;
		while(existance.size() != 0) {
			year += 1;
			melting();
			
			lump = 0;
			boolean[][] visited = new boolean[r][c];
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(ocean[i][j] == 0)
						continue;
					
					if(visited[i][j])
						continue;
					
					dfs(i, j, visited);
					lump += 1;
				}
			}
			
			if(lump >= 2)
				break;
		}
		
		if(existance.size() == 0)
			year = 0;
		
		System.out.println(year);
	}
	
	//빙산 녹이기
	public static void melting() {
		int[][] temp = new int[r][c]; //임시 ocean
		
		for(int i = 0; i < existance.size(); i++) {
			Iceberg cur = existance.get(i);
			
			int after = cur.size - findAdjacent(cur.r, cur.c);
			
			if(after < 0) {
				existance.remove(i);
				i--;
				continue;
			}
			
			temp[cur.r][cur.c] = after;
			existance.get(i).size = after;
				
		}
		
		//녹은 빙산 반영
		for(int i = 0; i < r; i++)
			ocean[i] = temp[i].clone();
	}
	
	//인접 접한 바다 수 구하기
	public static int findAdjacent(int i, int j) {
		int count = 0;
		
		for(int k = 0 ; k < 4; k++) {
			
			int ni = i + dx[k];
			int nj = j + dy[k];
			
			if(ni >= r || ni < 0 || nj >= c || nj < 0)
				continue;
			
			if(ocean[ni][nj] == 0)
				count++;
		}
		
		return count;
	}
	
	//빙산 덩어리 구하기
	public static void dfs(int i, int j, boolean[][] visited) {
		if(ocean[i][j] == 0)
			return;
		
		for(int k = 0; k < 4; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			
			if(ni >= r || ni < 0 || nj >= c || nj < 0)
				continue;
			
			if(visited[ni][nj])
				continue;
			
			visited[ni][nj] = true;
			dfs(ni, nj, visited);
		}
	}
}
