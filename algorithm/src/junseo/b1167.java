package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	
	static List<Edge> [] list;
	static boolean [] vis;
	static int[] distance;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int V = Integer.parseInt(br.readLine());
		
		list = new List[V+1];
		vis = new boolean[V+1];
		distance = new int[V+1];
		
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		for (int i = 1; i <=V ; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			while(true) {
				int node = Integer.parseInt(st.nextToken());
				if(node == -1) break;
				list[v].add(new Edge(node,Integer.parseInt(st.nextToken())));
			}
		}
		
		BFS(1);

		int max = 1;
		for (int i = 2; i <= V; i++) {
			if(distance[max]< distance[i]) {
				max = i;
			}
		}
		vis = new boolean[V+1];
		distance = new int[V+1];

		BFS(max);
		
		Arrays.sort(distance);
		System.out.println(distance[V]);
		
		
	}
	private static void BFS(int idx) {
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(idx);
		vis[idx] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (Edge edge : list[cur]) {
				if(!vis[edge.node]) {
					vis[edge.node] = true;
					queue.add(edge.node);
					distance[edge.node] = distance[cur] + edge.val;
				}
			}		
		}
	}
	static class Edge {
		int node;
		int val;
		public Edge(int node,int val) {
			this.node = node;
			this.val = val;
		}
	}

}



