package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 1325
 * 효율적인 해킹
 * 실버 1
 * https://www.acmicpc.net/problem/1325
 */
public class b1325 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
		int m = Integer.parseInt(st.nextToken()); // 간선 수
		
		List<Integer>[] relation = new ArrayList[n + 1];
		
		for(int i = 1; i < n + 1; i++)
			relation[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relation[b].add(a);
		}
		
		PriorityQueue<Integer> l = new PriorityQueue<>();
		int max = -1;
		for(int i = 1; i < n + 1; i++) {
			int cnt = bfs(relation, n, i);
			if(cnt < max)
				continue;
			
			if(cnt > max) {
				max = cnt;
				l = new PriorityQueue<>();
				l.add(i);
			} else if( cnt == max)
				l.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : l)
			sb.append(i + " ");
		System.out.println(sb);
	}
	
	public static int bfs(List<Integer>[] relation, int n, int start) {
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		
		int cnt = 0;
		
		visited[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			cnt += 1;
			int cur = q.poll();
			
			for(int i : relation[cur]) {
				if(visited[i])
					continue;
				visited[i] = true;
				q.add(i);
			}
			
		}
		
		return cnt;
	}
}
