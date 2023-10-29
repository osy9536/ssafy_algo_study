package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b18352 {
	static int n, m;
	static int k, x;
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
	
	static List<List<Integer>> list = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
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
			
			
			list.get(a).add(b);
			
		}
		
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		que.add(new Node(x, 0));
		dij[x] = 0;
		
		while (!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.end]) continue;
			visit[now.end] = true;
			
			for (int node : list.get(now.end)) {
				int summ = now.weight + 1;
				if (summ < dij[node]) {
					if (!visit[node]) que.add(new Node(node, summ));
					dij[node] = summ;
				}
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = 1; i < dij.length; i++) {
			if (dij[i] == k) result.add(i);
		}
		
		if (result.size() == 0) System.out.println(-1);
		else {
			for (int i : result) System.out.println(i);
		}
		
	}
}
