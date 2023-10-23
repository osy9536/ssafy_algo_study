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

public class b5972 {

	static int N, M, start, end, val, INF=Integer.MAX_VALUE;
	static int[] dist;
	static boolean isVisited[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] list ;
		isVisited = new boolean[N+1];
		dist = new int[N+1];
		
		Arrays.fill(dist, INF);
		
		list= new ArrayList[N+1];
		for(int i = 0 ; i < N+1 ; i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			val = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end,val));
			list[end].add(new Node(start,val));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node (1,0));
		dist[1]=0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!isVisited[now.end]) isVisited[now.end] =true;
			else continue;
			
			for(int i = 0 ; i < list[now.end].size();i++) {
				Node next = list[now.end].get(i);
				if(dist[next.end]> dist[now.end]+next.val) {
					dist[next.end] = dist[now.end]+next.val;
					pq.add(new Node(next.end,dist[next.end]));
				}
			}
		}
		
		System.out.println(dist[N]);
	}
}
/*
 * 6 4 0100 1110 1000 0000 0111 0000
 */