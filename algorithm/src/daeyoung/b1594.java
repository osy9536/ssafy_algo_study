package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 1504
 * 특정한 최단 경로
 * 골드 4
 * https://www.acmicpc.net/problem/1504
 */
public class b1504 {
	
	static class Node implements Comparable<Node> {
		int v;
		long cost;
		
		Node(int v, long cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return Long.compare(this.cost, n.cost);
		}
	}
	
	static List<Node>[] g;
	static int n;
	static long[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 정점 수
		int e = Integer.parseInt(st.nextToken()); // 간선 수
		
		g = new ArrayList[n + 1];
		for(int i = 1; i < n + 1; i++)
			g[i] = new ArrayList<>();
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long cost = Integer.parseInt(st.nextToken());
			
			g[a].add(new Node(b, cost));
			g[b].add(new Node(a, cost));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		long answer1 = 0;
		//1 -> v1
		init();
		answer1 += dijkstra(1, v1);
		
		//v1 -> v2
		init();
		if(answer1 != Long.MAX_VALUE)
			answer1 += dijkstra(v1, v2);
		
		//v2 -> n
		init();
		if(answer1 != Long.MAX_VALUE && answer1 > 0)
			answer1 += dijkstra(v2, n);
		
		int answer2 = 0;
		//1 -> v2
		init();
		answer2 += dijkstra(1, v2);
		
		//v2 -> v1
		init();
		if(answer2 != Long.MAX_VALUE)
			answer2 += dijkstra(v2, v1);
		
		//v1 -> n
		init();
		if(answer2 != Long.MAX_VALUE && answer2 > 0)
			answer2 += dijkstra(v1, n);
		
		answer1 = Math.min(answer1, answer2);
		
		if(answer1 == Long.MAX_VALUE || answer1 <= 0)
			answer1 = -1;
		
		System.out.println(answer1);
	}
	
	public static long dijkstra(int s, int e) {
		
		distance[s] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		
		while(!pq.isEmpty()) {
			int curV = pq.poll().v;
			
			if(visited[curV])
				continue;
			
			for(Node next : g[curV]) {
				if(distance[next.v] > distance[curV] + next.cost) {
					distance[next.v] = distance[curV] + next.cost;
					pq.add(new Node(next.v, distance[next.v]));
				}
			}
		}
		
		
		return distance[e];
	}
	
	public static void init() {
		
		visited = new boolean[n + 1];
		distance = new long[n + 1];
		
		for(int i = 0; i < n + 1; i++) {
			distance[i] = Long.MAX_VALUE;
		}
	}
	
}
