package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b5972 {
	static int n, m;
	static boolean[] visit;
	static int[] dij;
	
	static class Node implements Comparable<Node>{
		int end, weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static List<List<Node>> list = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		dij = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			dij[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		que.add(new Node(1, 0));
		dij[1] = 0;
		
		while (!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.end]) continue;
			visit[now.end] = true;
			
			for (Node node : list.get(now.end)) {
				int summ = now.weight + node.weight;
				if (summ < dij[node.end]) {
					if (!visit[node.end]) que.add(new Node(node.end, summ));
					dij[node.end] = summ;
				}
			}
		}
		
		System.out.println(dij[n]);
		
	}
}
