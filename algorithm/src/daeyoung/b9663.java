package algorithm.src.daeyoung;

import java.io.*;

/**
 * 백준 9663
 * N-Queen
 * 골드4
 * https://www.acmicpc.net/problem/9663
 */
public class b9663 {
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] plate = new boolean[n][n];
		
		backTrack(plate, n, 0, 0);
		System.out.println(cnt);
	}
	
	public static void backTrack(boolean[][] plate, int n, int r, int c) {
		if(r == n) {
			cnt++;
			
			return;
		}
		
		//자식 노드 확인
		for(int j = 0; j < plate.length; j++) {
			plate[r][j] = true;
			//유망한지 확인
			if(!promising(plate, r, j)) {
				plate[r][j] = false;
				continue;
			}
			backTrack(plate, n, r + 1, c);
			plate[r][j] = false;
			
		}
	}
	
	public static boolean promising(boolean[][] plate, int r, int c) {
		//왼
		for(int j = c - 1; j >= 0; j--) {
			if(plate[r][j])
				return false;
		}
		
		//오른
		for(int j = c + 1; j < plate.length; j++) {
			if(plate[r][j])
				return false;
		}
		
		//아래
		for(int i = r + 1; i < plate.length; i++) {
			if(plate[i][c])
				return false;
		}
		
		//위
		for(int i = r - 1; i >= 0; i--) {
			if(plate[i][c])
				return false;
		}
		
		//오른위
		int i = r;
		int j = c;
		while(true) {
			i -= 1;
			j += 1;
			
			if(i < 0 || j >= plate.length)
				break;
			
			if(plate[i][j])
				return false;
		}
		
		//왼위
		i = r;
		j = c;
		while(true) {
			i -= 1;
			j -= 1;
			
			if(i < 0 || j < 0)
				break;
			
			if(plate[i][j])
				return false;
		}
		
		//오른아래
		i = r;
		j = c;
		while(true) {
			i += 1;
			j += 1;
			
			if(i >= plate.length || j >= plate.length)
				break;
			
			if(plate[i][j])
				return false;
		}
		
		//왼아래
		i = r;
		j = c;
		while(true) {
			i += 1;
			j -= 1;
			
			if(i >= plate.length || j < 0)
				break;
			
			if(plate[i][j])
				return false;
		}
		
		return true;
	}
	
}
