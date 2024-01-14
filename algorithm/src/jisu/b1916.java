package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1916 {
	static int n, m, result;
	static int INF = Integer.MAX_VALUE;
	
	static int[] dij;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	static class Node implements Comparable<Node> {
		int end, weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		List<List<Node>> list = new ArrayList<>();
		
		dij = new int[n+1];
		visit = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			dij[i] = INF;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int de = Integer.parseInt(st.nextToken());
			int ar = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list.get(de).add(new Node(ar, time));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		Queue<Node> que = new PriorityQueue<>();
		que.add(new Node(start, 0));
		dij[start] = 0;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.end]) continue;
			visit[now.end] = true;
			for (Node node : list.get(now.end)) {
				int acc = now.weight + node.weight;
				if (dij[node.end] > acc) {
					if (!visit[node.end]) que.add(new Node(node.end, acc));
					dij[node.end] = acc;
				}
			}
		}
		
		System.out.println(dij[end]);
		
	}
}

