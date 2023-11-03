package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Node implements Comparable<Node>{
	int end;
	long val;
	
	public Node(int end, long val) {
		this.end = end;
		this.val = val;
	}

	@Override
	public int compareTo(Node o) {
		return this.val>o.val?1:-1;
	}
	
}
public class b17396 {
	static int N,M;
	static long INF=Long.MAX_VALUE;
	static boolean[] check ;
	static ArrayList<Node>[] list;
	static long[] dist;
	
	public static long Dijkstra(int start, int arrive) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,0));
		boolean[] isVisited = new boolean[N];
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(isVisited[now.end]) continue;
			isVisited[now.end]=true;
			for(Node next : list[now.end]) {
			
				if(next.end!=arrive && check[next.end]) continue;
				
				if(dist[next.end] > dist[now.end]+next.val)
				{
					dist[next.end] = dist[now.end]+next.val;
					pq.offer(new Node(next.end,dist[next.end]));
				}
			}
		}
		if(dist[arrive]==INF)
			return -1;
		return dist[arrive]; 
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N];
		list = new ArrayList[N];
		dist = new long[N];
		
		for(int i = 0 ; i < N;i++) {
			list[i] = new ArrayList<>();
			dist[i] = INF;
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i =0  ; i <N ; i ++) {
			if(st.nextToken().equals("1")) {
				check[i] = true;
			}
		}
		for(int i =0 ; i<M ;i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
			
		}
		
		System.out.println(Dijkstra(0,N-1));
	}
}