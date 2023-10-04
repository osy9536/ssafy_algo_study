package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 9205 
 * 맥주 마시면서 걸어가기
 * 골드 5
 * https://www.acmicpc.net/problem/9205
 */
public class b9205 {
	
	public static int t; //test case
	public static int n; //편의점 개수
	public static List<int[]> location; //편의점 좌표 정보
	public static boolean[] visited; //깊이, location index
	
	public static boolean answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		t = Integer.parseInt(st.nextToken());
		
		for(int c = 0; c < t; c++) {
			answer = false;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			location = new ArrayList<>();
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				location.add(new int[] {x, y});
			}
			
			int size = location.size();
			visited = new boolean[size];
			
			bfs(location.get(0));
			
			if(answer)
				sb.append("happy");
			else
				sb.append("sad");
			
			sb.append("\n");
		}
			
		System.out.print(sb.toString());
	}
	
	
	public static void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>(); //x, y, depth, index
		
		q.add(new int[] {start[0], start[1], 0, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == location.get(location.size() - 1)[0] && 
					cur[1] == location.get(location.size() - 1)[1]) {
				answer = true;
				return;
			}
			
			for(int i = 1; i < location.size(); i++) {
				if(visited[i]) {
					continue;
				}
				
				int d = Math.abs(cur[0] - location.get(i)[0]) + 
						Math.abs(cur[1] - location.get(i)[1]);
				if(d > 1000) {
					continue;
				}
				else {
					visited[i] = true;
					q.add(new int[] {location.get(i)[0], location.get(i)[1], 
							cur[2] + 1, i});
				}
					
			}
		}
	}
	
}
