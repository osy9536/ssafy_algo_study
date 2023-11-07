package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		return this.val-o.val;
	}
	
}
public class b11779 {
	
	static int N ; // 도시의 갯수 (정점)
	static int M ; // 버스의 갯수 (간선)
	static ArrayList<Node>[] list;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Integer>[] city;
	static boolean[] isVisited;
	
	static void Dijkstra(int s, int e) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s,0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			
			Node now = pq.poll();
			if(isVisited[now.end]) continue;
			isVisited[now.end] = true;
			for(Node next:list[now.end]) {
				
				if(dist[next.end]>dist[now.end]+next.val) {
					dist[next.end]=dist[now.end]+next.val;
					city[next.end]=(ArrayList<Integer>) city[now.end].clone();
					city[next.end].add(now.end);
					pq.add(new Node(next.end,dist[next.end]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		city = new ArrayList[N+1];
		dist = new int[N+1];
		isVisited = new boolean[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			list[i] = new ArrayList<>();
			dist[i] = INF;
			city[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st  = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,v));
		}
		st  = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int arrive = Integer.parseInt(st.nextToken());
		
		Dijkstra(start,arrive);
		System.out.println(dist[arrive]);
		System.out.println(city[arrive].size()+1);
		for(int a : city[arrive]) {
			System.out.print(a+" ");
		}
		System.out.println(arrive);
	}
}