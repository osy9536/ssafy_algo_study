package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 15683
 * 감시
 * 골드4
 * https://www.acmicpc.net/problem/15683
 */
public class b15683 {
	
	static int n;
	static int m;
	
	static int[][] area;
	
	static List<int[]> cctv;
	
	//최소 크기
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cctv = new ArrayList<>();
		area = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				
				if(area[i][j] > 0 && area[i][j] < 6)
					cctv.add(new int[] {i, j});
			}
		}
		
		dfs(cctv, 0);
		
		System.out.println(min);		
	}
	
	public static void dfs(List<int[]> q, int index) {
		if(index == q.size()) {
			int cnt = 0;
		
			//사각 지대 찾기
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
//					System.out.printf("%2d ", area[i][j]);
					if(area[i][j] == 0)
						cnt++;
				}
//				System.out.println();
			}
			
			//최소 크기 구하기
			min = Math.min(cnt, min);
			
//			System.out.println(min);
			return;
		}
		
		int[] cur = q.get(index);
		
		if(area[cur[0]][cur[1]] == 1) {
			//상
			up(cur[0], cur[1]);
			dfs(q, index + 1);
			//맵 돌리기
			backUp(cur[0], cur[1]);
			
			//하
			down(cur[0], cur[1]);
			dfs(q, index + 1);
			backDown(cur[0], cur[1]);
			
			//좌
			left(cur[0], cur[1]);
			dfs(q, index + 1);
			backLeft(cur[0], cur[1]);
			
			//우
			right(cur[0], cur[1]);
			dfs(q, index + 1);
			backRight(cur[0], cur[1]);
		} else if(area[cur[0]][cur[1]] == 2) {
			//좌 우
			left(cur[0], cur[1]);
			right(cur[0], cur[1]);
			dfs(q, index + 1);
			
			//되돌리기
			backLeft(cur[0], cur[1]);
			backRight(cur[0], cur[1]);
			
			//상 하
			up(cur[0], cur[1]);
			down(cur[0], cur[1]);
			dfs(q, index + 1);
			
			//되돌리기
			backUp(cur[0], cur[1]);
			backDown(cur[0], cur[1]);
			
		} else if(area[cur[0]][cur[1]] == 3) {
			//위 오른쪽
			up(cur[0], cur[1]);
			right(cur[0], cur[1]);
			dfs(q, index + 1);
			backUp(cur[0], cur[1]);
			backRight(cur[0], cur[1]);
			
			//오른쪽 아래
			right(cur[0], cur[1]);
			down(cur[0], cur[1]);
			dfs(q, index + 1);
			backRight(cur[0], cur[1]);
			backDown(cur[0], cur[1]);
			
			//아래 왼쪽
			down(cur[0], cur[1]);
			left(cur[0], cur[1]);
			dfs(q, index + 1);
			backDown(cur[0], cur[1]);
			backLeft(cur[0], cur[1]);
			
			//왼쪽 위
			left(cur[0], cur[1]);
			up(cur[0], cur[1]);
			dfs(q, index + 1);
			backLeft(cur[0], cur[1]);
			backUp(cur[0], cur[1]);
			
		} else if(area[cur[0]][cur[1]] == 4) {
			//상 빼고
			down(cur[0], cur[1]);
			left(cur[0], cur[1]);
			right(cur[0], cur[1]);
			dfs(q, index + 1);
			backDown(cur[0], cur[1]);
			backLeft(cur[0], cur[1]);
			backRight(cur[0], cur[1]);
			
			//하 빼고
			up(cur[0], cur[1]);
			left(cur[0], cur[1]);
			right(cur[0], cur[1]);
			dfs(q, index + 1);
			backUp(cur[0], cur[1]);
			backLeft(cur[0], cur[1]);
			backRight(cur[0], cur[1]);
			
			//좌 빼고
			up(cur[0], cur[1]);
			down(cur[0], cur[1]);
			right(cur[0], cur[1]);
			dfs(q, index + 1);
			backUp(cur[0], cur[1]);
			backDown(cur[0], cur[1]);
			backRight(cur[0], cur[1]);
			
			//우 빼고
			up(cur[0], cur[1]);
			left(cur[0], cur[1]);
			down(cur[0], cur[1]);
			dfs(q, index + 1);
			backUp(cur[0], cur[1]);
			backLeft(cur[0], cur[1]);
			backDown(cur[0], cur[1]);
			
		} else if(area[cur[0]][cur[1]] == 5) {
			up(cur[0], cur[1]);
			down(cur[0], cur[1]);
			left(cur[0], cur[1]);
			right(cur[0], cur[1]);
			dfs(q, index + 1);
			backUp(cur[0], cur[1]);
			backDown(cur[0], cur[1]);
			backLeft(cur[0], cur[1]);
			backRight(cur[0], cur[1]);
		}
		
		
	}
	
	public static void up(int r, int c) {
		for(int i = r - 1; i >= 0; i--) {
			if(area[i][c] == 6)
				break;
			if(area[i][c] <= 0)
				area[i][c] -= 1;
		}
	}
	
	public static void backUp(int r, int c) {
		for(int i = r - 1; i >= 0; i--) {
			if(area[i][c] == 6)
				break;
			if(area[i][c] <= -1)
				area[i][c] += 1;
		}
	}
	
	public static void down(int r, int c) {
		for(int i = r + 1; i < n; i++) {
			if(area[i][c] == 6)
				break;
			if(area[i][c] <= 0)
				area[i][c] -= 1;
		}
	}
	
	public static void backDown(int r, int c) {
		for(int i = r + 1; i < n; i++) {
			if(area[i][c] == 6)
				break;
			if(area[i][c] <= -1)
				area[i][c] += 1;
		}
	}
	
	public static void left(int r, int c) {
		for(int j = c - 1; j >= 0; j--) {
			if(area[r][j] == 6)
				break;
			if(area[r][j] <= 0)
					area[r][j] -= 1;
		}
	}
	
	public static void backLeft(int r, int c) {
		for(int j = c - 1; j >= 0; j--) {
			if(area[r][j] == 6)
				break;
			if(area[r][j] <= -1)
				area[r][j] += 1;
		}
	}
	
	public static void right(int r, int c) {
		for(int j = c + 1; j < m; j++) {
			if(area[r][j] == 6)
				break;
			if(area[r][j] <= 0)
				area[r][j] -= 1;
		}
	}
	
	public static void backRight(int r, int c) {
		for(int j = c + 1; j < m; j++) {
			if(area[r][j] == 6)
				break;
			if(area[r][j] <= -1)
				area[r][j] += 1;
		}
	}
	
	
}
