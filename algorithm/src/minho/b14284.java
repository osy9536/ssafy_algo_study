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
		return this.val-o.val;
	}
	
}
public class Main {
	
	static int N, M;
	static ArrayList<Node>[] list;
	static int[] dist;
	static int INF=Integer.MAX_VALUE;
	
	public static int Dijkstra(int a, int b) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(a,0));
		dist[a]=0;
		while(!pq.isEmpty()) {
			
			Node now = pq.poll();
			
			for(Node next : list[now.end]) {
				if(dist[next.end]>dist[now.end]+next.val) { //현재까지의 다음 루트 가중치 VS 다음루트가는데 새로 더 걸릴가중치
					dist[next.end]=dist[now.end]+next.val;
					pq.add(new Node(next.end,dist[next.end]));
				}
			}
		}
		return dist[b];
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M =  Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i = 0 ; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(dist, INF);
		
		for(int i = 0 ; i < M ; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int arrive = Integer.parseInt(st.nextToken());
		
		System.out.println(Dijkstra(start, arrive));
		
		
		
	}
}