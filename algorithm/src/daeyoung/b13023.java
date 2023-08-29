package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Iterator;

/**
 * 백준 13023
 * ABCDE
 * 골드5
 * https://www.acmicpc.net/problem/13023
 */
public class b13023 {
	
	static List<Integer>[] relation;
	static boolean[] visited;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //총 인원
		int m = Integer.parseInt(st.nextToken()); //친구 관계
		
		relation = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			relation[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relation[a].add(b);
			relation[b].add(a);
		}
		
		for(int i = 0; i < n; i++) {
			if(answer == 1)
				break;
			visited = new boolean[n];
			dfs(i, 0);
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int cur, int depth) {
		if(depth == 4) {
			answer = 1;
			return;
		}
		visited[cur] = true;
		for(int i = 0; i < relation[cur].size(); i++) {
			if(visited[relation[cur].get(i)])
				continue;
			dfs(relation[cur].get(i), depth + 1);
		}
		visited[cur] = false;
	}
	
	
}
