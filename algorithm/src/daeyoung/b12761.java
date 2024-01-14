package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 12761
 * 돌다리
 * https://www.acmicpc.net/problem/12761
 */
public class b12761 {
                   
	static int[] visited;
	static int a;
	static int b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken()); // +a, -a, *a 
		b = Integer.parseInt(st.nextToken()); // +b, -b, *b
		
		int n = Integer.parseInt(st.nextToken()); // 동규 현재 위치
		int m = Integer.parseInt(st.nextToken()); // 주미 현재 위치
		
		visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		bfs(n, m);
		System.out.println(visited[m]);
	}
	
	public static void bfs(int n, int m) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {n, 0});
		visited[n] = 0;
		
		int[] temp;
		int cur, cnt;
		while(!q.isEmpty()) {
			
			temp = q.poll();
			cur = temp[0];
			cnt = temp[1];
			
			if(cur == m) {
				visited[cur] = Math.min(cnt, visited[cur]);
				break;	
			}
			
			if(cur + 1 < 100001 && cnt + 1 < visited[cur + 1]) {
				q.add(new int[] {cur + 1, cnt + 1});
				visited[cur + 1] = cnt + 1;
			}
			
			if(cur - 1 >= 0 && cnt + 1 < visited[cur - 1]) {
				q.add(new int[] {cur - 1, cnt + 1});
				visited[cur - 1] = cnt + 1;
			}
			
			if(cur + a < 100001 && cnt + 1 < visited[cur + a]) {
				q.add(new int[] {cur + a, cnt + 1});
				visited[cur + a] = cnt + 1;
			}
			
			if(cur - a >= 0 && cnt + 1 < visited[cur - a]) {
				q.add(new int[] {cur - a, cnt + 1});
				visited[cur - a] = cnt + 1;
			}
			
			if(cur + b < 100001 && cnt + 1 < visited[cur + b]) {
				q.add(new int[] {cur + b, cnt + 1});
				visited[cur + b] = cnt + 1;
			}
			
			if(cur - b >= 0 && cnt + 1 < visited[cur - b]) {
				q.add(new int[] {cur - b, cnt + 1});
				visited[cur - b] = cnt + 1;
			}
			
			if(cur * a < 100001 && cnt + 1 < visited[cur * a]) {
				q.add(new int[] {cur * a, cnt + 1});
				visited[cur * a] = cnt + 1;
			}
			
			if(cur * b < 100001 && cnt + 1 < visited[cur * b]) {
				q.add(new int[] {cur * b, cnt + 1});
				visited[cur * b] = cnt + 1;
			}
			
		}
	}
}
