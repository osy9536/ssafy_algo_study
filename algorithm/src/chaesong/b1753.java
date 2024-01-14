import java.io.*;
import java.util.*;

public class b1753 {
	static class Node implements Comparable<Node>{
		int n, e;
		
		public Node(int n, int e) {
			this.n = n; //인접한 노드
			this.e = e; //가중치
		}

		@Override
		public String toString() {
			return "Node [n=" + n + ", e=" + e + "]";
		}

		@Override
		//가중치에 따라서 오름차순 정렬
		public int compareTo(Node node) {
			return this.e - node.e;
		}
		
	}
	static int V, E, K;
	static ArrayList<Node> arr[];
	static boolean visit[];
	static int dist[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); //정점 개수
		E = Integer.parseInt(st.nextToken()); //간선 개수
		K = Integer.parseInt(br.readLine()); //시작 정점
		arr = new ArrayList[V+1];
		visit = new boolean[V+1];
		dist = new int[V+1];
		
		//인접 리스트 구현
		for(int i = 1; i <= V; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); //출발 정점
			int v = Integer.parseInt(st.nextToken()); //도착 정점
			int e = Integer.parseInt(st.nextToken()); //가중치
			arr[u].add(new Node(v, e));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		bfs(K);
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) bw.write("INF\n");
			else bw.write(dist[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void bfs(int K) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(K, 0));
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(visit[temp.n]) continue;
			visit[temp.n] = true;
			for(Node next: arr[temp.n]) {
				int n = next.n;
				int e = next.e;
				if(dist[n] > dist[temp.n]+e) {					
					dist[n] = dist[temp.n]+e;
					q.add(new Node(n, dist[n]));
				}
			}
		}
	}
}
