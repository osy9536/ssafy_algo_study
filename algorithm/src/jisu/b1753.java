package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1753 { 
	static int n;
	static int m;
	static int f;
	
	static int INF = Integer.MAX_VALUE;
	
    static boolean[] visit;
    static List<List<Node>> list = new ArrayList<>();
    
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		int[] dij = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
			dij[i] = INF;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int de = Integer.parseInt(st.nextToken());
			int ar = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list.get(de).add(new Node(ar, time));
		}
		
		Queue<Node> que = new PriorityQueue<>();
		que.add(new Node(f, 0));
		dij[f] = 0;
		int vcnt = n;
		
		while (vcnt > 0 && !que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.end]) continue;
			visit[now.end] = true;
			vcnt--;
			for (Node node : list.get(now.end)) {
				int i = node.end;
				int len = node.weight;
				if (dij[i] > now.weight + len) {
					if (!visit[i]) que.add(new Node(i, now.weight+len));
					dij[i] = now.weight + len;
				}
			}
		}
		
		for (int i = 1; i < dij.length; i++) {
			if (dij[i] == INF) bw.write("INF\n");
			else bw.write(dij[i] + "\n");
		}
        
        bw.flush();
        bw.close();
	}
}
