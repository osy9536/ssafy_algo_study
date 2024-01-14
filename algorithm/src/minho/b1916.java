package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{

	int end;
	int val;

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

public class b1916 {

	static int N, M, start, end, INF=Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>> map;
	static int[] dist;
	
	public static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N+1];
		pq.offer(new Node(start,0));
		dist[start]=0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int nend = n.end;
			if(!check[nend]) {
				check[nend] = true;
				for(Node node : map.get(nend)) {
					if(!check[node.end] && dist[node.end] > dist[nend]+node.val) {
						dist[node.end] = dist[nend]+ node.val;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		return dist[end];
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new ArrayList<>();
		dist= new int[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i = 0 ; i <= N+1 ; i++) {
			map.add(new ArrayList<>());
		}
			
		
		for(int i = 0 ; i < M ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			map.get(start).add(new Node(end,val));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra());
	}
}
/*
 * 6 4 0100 1110 1000 0000 0111 0000
 */