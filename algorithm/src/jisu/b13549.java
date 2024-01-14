package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b13549 { 
	static int n;
	static int m;
	
	static int INF = Integer.MAX_VALUE;
	
	static int[] dij;
    static boolean[] visit;
    static Queue<Node> que = new PriorityQueue<>();
    
    static class Node implements Comparable<Node> {
    	int end, weight;
    	public Node(int end, int weight) {
    		this.end = end;
    		this.weight = weight;
    	}
    	
    	@Override
    	public int compareTo(Node o) {
    		if (this.weight == o.weight) return this.end - o.end;
    		return this.weight - o.weight;
    	}
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dij = new int[100001];
		visit = new boolean[100001];
		
		for (int i = 0; i < 100001; i++) {
			dij[i] = INF;
		}
		
		que = new PriorityQueue<>();
		que.add(new Node(n, 0));
		dij[n] = 0;
		
		while (!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.end]) continue;
			visit[now.end] = true;
			int x = now.end;
			while (x < m && Math.abs(x*2 - m) < Math.abs(x - m) && x*2 <= 100000) {
				x *= 2;
				if (dij[x] > now.weight) {
					if (!visit[x]) que.add(new Node(x, now.weight));
					dij[x] = now.weight;
				}
			}
			if (now.end > 0 && dij[now.end-1] > now.weight+1) {
				if (!visit[now.end-1]) que.add(new Node(now.end-1, now.weight+1));
				dij[now.end-1] = now.weight+1;
			}
			if (now.end < 100000 && now.end + 1 <= m && dij[now.end+1] > now.weight+1) {
				if (!visit[now.end+1]) que.add(new Node(now.end+1, now.weight+1));
				dij[now.end+1] = now.weight+1;
			}
		}
		
		
		System.out.println(dij[m]);
		
	}
}
