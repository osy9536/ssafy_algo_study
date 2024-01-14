import java.util.*;
import java.io.*;

public class b1916 {
	static class Node implements Comparable<Node>{
		int e, w;
		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		@Override
		public String toString() {
			return "Node [e=" + e + ", w=" + w + "]";
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Node> list[] = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, w));
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); // 출발 지점
		int b = Integer.parseInt(st.nextToken()); // 도착 지점
		
		
		// 다익스트라
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[a] = 0;
		
		boolean visit[] = new boolean[N+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(a, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int e = now.e;
			int w = now.w;
			if(visit[e]) continue;
			visit[e] = true;
			for(Node nxt: list[e]) {
				if(dist[nxt.e] > dist[e] + nxt.w) {
					dist[nxt.e] = dist[e] + nxt.w;
					pq.add(new Node(nxt.e, dist[nxt.e]));
				}
			}
		}
		
		System.out.println(dist[b]);
	}
}
