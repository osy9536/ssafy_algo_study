package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 17471
 * 게리맨더링
 * 골드 4
 * https://www.acmicpc.net/problem/17471
 */
public class b17471 {
	
	//구역의 개수
	static int n;
	static int[] people; // 인구 수
	static List<Integer>[] g;// 간선
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		people = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		g = new ArrayList[n + 1];
		for(int i = 1; i < n + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			g[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt  = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < cnt; j++) {
				g[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		visited = new boolean[n + 1];
		
		for(int i = 1; i < n / 2 + 1; i++)
			combi(1, i);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	public static void combi(int cur, int depth) {
		if(depth == n) {
			
			List<Integer> g1 = new ArrayList<>();
			List<Integer> g2 = new ArrayList<>();
			
			int num1 = 0;
			int num2 = 0;
			for(int i = 1; i < n + 1; i++) {
				if(visited[i]) {
					g1.add(i);
					num1 += people[i];
				} else {
					g2.add(i);
					num2 += people[i];
				}
					
			}
			
//			System.out.println();
//			for(int i = 0; i < g1.size(); i++)
//				System.out.print(g1.get(i) + " ");
//			System.out.println();
//			for(int i = 0; i < g2.size(); i++)
//				System.out.print(g2.get(i) + " ");
//			System.out.println();
			
			//두 그룹 연결 확인
			if(isConnect(g1) && isConnect(g2)) {
				min = Math.min(min, Math.abs(num1 - num2));
			}
		}
		
		for(int i = cur; i < n + 1;  i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			combi(i + 1, depth + 1);
			visited[i] = false;
		}
	}
	
	public static boolean isConnect(List<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		
		visited[list.get(0)] = true;
		q.add(list.get(0));
		
		int count = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 0; i < g[cur].size(); i++) {
				if(list.contains(g[cur].get(i)) && !visited[g[cur].get(i)]) {
					q.add(g[cur].get(i));
					visited[g[cur].get(i)] = true;
					count += 1;
				}
			}
		}
		
		if(count == list.size())
			return true;
		else
			return false;
		
	}
	
	
}
