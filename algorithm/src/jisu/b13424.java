package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b13424 { 
	static int n;
	static int m;
	
	static int INF = Integer.MAX_VALUE;
	
    static int[][] map;
	static int[][] dij;
    static boolean[] visit;
    static List<List<Node>> list;
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

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			dij = new int[n+1][n+1];
			list = new ArrayList<>();
			
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					dij[i][j] = INF;
				}
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int de = Integer.parseInt(st.nextToken());
				int ar = Integer.parseInt(st.nextToken());
				int len = Integer.parseInt(st.nextToken());
				list.get(de).add(new Node(ar, len));
				list.get(ar).add(new Node(de, len));
			}
			
			int k = Integer.parseInt(br.readLine());
			int[] friends = new int[k];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < friends.length; i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int f : friends) {
				visit = new boolean[n+1];
				dij[f][f] = 0;
				que.clear();
				que.add(new Node(f, 0));
				
				while (!que.isEmpty()) {
					Node now = que.poll();
					if (visit[now.end]) continue;
					visit[now.end] = true;
					for (Node node : list.get(now.end)) {
						int w = node.weight + now.weight;
						if (dij[f][node.end] > w) {
							dij[f][node.end] = w;
							if (!visit[node.end]) que.add(new Node(node.end, w));
						}
					}
				}
			}
			
			int[] summ = new int[n+1];
			
			for (int i = 0; i < k; i++) {
				for (int j = 1; j <= n; j++) {
					summ[j] += dij[friends[i]][j];
				}
			}
			
			int minVal = Integer.MAX_VALUE;
			int minIdx = 0;
			
			for (int i = 1; i <= n; i++) {
				if (summ[i] < minVal) {
					minVal = summ[i];
					minIdx = i;
				}
			}
			
			System.out.println(minIdx);
		}

	}
}
