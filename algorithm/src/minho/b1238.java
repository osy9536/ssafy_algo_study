package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end, val;

	public Node(int end, int val) {
		super();
		this.end = end;
		this.val = val;
	}

	@Override	
	public int compareTo(Node o) {
		return this.val - o.val;
	}
	
}

public class b1238 {

	static int N,M,X;
	static ArrayList<Node>[] list;
	static int[] dist , ans;
	static boolean[] isVisited;
	
	public static int dijkstra(int s, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s,0));
		dist[s] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(isVisited[now.end]) continue;
			isVisited[now.end] = true;
			for(Node n : list[now.end]) {
				if(dist[n.end] > dist[now.end]+n.val) {
					dist[n.end] = dist[now.end]+n.val;
					pq.add(new Node(n.end,dist[n.end]));
				}
			}	
		}
		return dist[e];
	}
		
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i = 0 ; i <= N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e,v));
		}
		
		ans = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			if(X==i) continue;
			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			isVisited = new boolean[N+1];
			ans[i]+=dijkstra(i,X);
			
			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			isVisited = new boolean[N+1];
			ans[i]+=dijkstra(X,i);
		}
		int max = Integer.MIN_VALUE;
		for(int a : ans) {
			if(max < a) {
				max = a;
			}
		}
		
		System.out.println(max);
	}
}
/*

 */