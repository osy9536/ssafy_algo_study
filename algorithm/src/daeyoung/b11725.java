package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 11725
 * 트리의 부모 찾기
 * 실버 2
 * https://www.acmicpc.net/problem/11725
 */
public class b11725 {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> l = new ArrayList<>();
		
		for(int i = 0; i < n + 1; i++)
			l.add(new ArrayList<Integer>());
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			l.get(a).add(b);
			l.get(b).add(a);
		}
		
		parent = new int[n + 1];
		bfs(l, 1, n);
		
		for(int i = 2; i < n + 1; i++)
			sb.append(parent[i]).append("\n");
		System.out.println(sb.toString());
	}
	
	public static void bfs(List<List<Integer>> l, int start, int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		
		visited[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i : l.get(cur)) {
				if(visited[i])
					continue;
				parent[i] = cur;
				visited[i] = true;
				q.add(i);
 			}
		}
	}
	
}

