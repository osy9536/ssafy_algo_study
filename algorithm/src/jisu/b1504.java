package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1504 { 
	static int n;
	static int m;
	
	static int INF = Integer.MAX_VALUE;
	static int[] dij;
    static boolean[] visit;
    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> que = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
    	int end, weight;
    	public Node(int end, int weight) {
    		this.end = end;
    		this.weight = weight;
    	}
    	
    	@Override
    	public int compareTo(Node o) {
    	// TODO Auto-generated method stub
    	return this.weight - o.weight;
    	}
    }
    
    public static void findPath(int start) {
    	dij = new int[n+1];
    	for (int i = 0; i < dij.length; i++) {
    		dij[i] = INF;
		}
		visit = new boolean[n+1];
		que.clear();
		que.add(new Node(start, 0));
		dij[start] = 0;
		
    	while(!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.end]) continue;
			visit[now.end] = true;
			for (Node node : list.get(now.end)) {
				int len = node.weight + now.weight;
				if (dij[node.end] > len) {
					dij[node.end] = len;
					if (!visit[node.end]) que.add(new Node(node.end, len));
				}
			}
		}
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dij = new int[n+1];
		visit = new boolean[n+1];
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			dij[i] = INF;
		}
		
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int de = Integer.parseInt(st.nextToken());
			int ar = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list.get(de).add(new Node(ar, time));
			list.get(ar).add(new Node(de, time));
		}
		
		st = new StringTokenizer(br.readLine());
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());
		
		
		int result = INF;
		
		
		que.clear();

		findPath(1);
		
		int a = dij[one];
		int b = dij[two];
		
		findPath(n);
		
		int mini = Integer.MAX_VALUE;
		int fir = 0;
		int sec = 0;
		
		if (a + dij[two] > b + dij[one]) {
			if (b == INF || dij[one] == INF) result = -1;
			mini = b + dij[one];
			fir = two;
			sec = one;
		} else {
			if (a == INF || dij[two] == INF) result = -1;
			mini = a + dij[two];
			fir = one;
			sec = two;
		}
		
		findPath(fir);
		
		if (dij[sec] == INF) result = -1;
		if (result != -1) result = mini + dij[sec];
		
		System.out.println(result);
		
	}
}
