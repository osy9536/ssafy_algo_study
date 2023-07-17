package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


/**
 * 백준 14889
 * 스타트와 링크
 * 실버2
 * https://www.acmicpc.net/problem/14889
 */
public class b14889 {
	
	//최소값
	static int min = Integer.MAX_VALUE;  
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		
		int[][] s = new int[n + 1][n + 1];
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j < n + 1; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//스타트팀 true, 링크팀 false
		boolean[] visited = new boolean[n + 1];
		
		// 종료 조건, n/2 인 경우
		int cnt = 0;
		int cur = 1;
		
		selectP(s, n, visited, cnt, cur);
		
		System.out.println(min);
	}
	
	public static void selectP(int[][] s, int n, boolean[] visited, int cnt, int cur) {
		if(cnt == n/2) {
			int start = 0;
			int link = 0;
			
			for(int i = 1; i < n + 1; i++) {
				if(visited[i]) {
					for(int j = 1; j < n + 1; j++) {
						if(visited[j]) {
							start += s[i][j];
						}
					}
				} else {
					for(int j = 1; j < n + 1; j++) {
						if(!visited[j]) {
							link += s[i][j];
						}
					}		
			
				}
			}
			
			min = Math.min(min, Math.abs(start - link));
			return;
		}
		
		for(int i = cur; i < n + 1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selectP(s, n, visited, cnt + 1, i + 1);
				visited[i] = false;
			}
		}
		
		
		
	}
		
}


