package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b11909 {
	static int n, m;
	static boolean[][] visit;
	static int[][] dij;
	
	static class Node implements Comparable<Node>{
		int y;
		int x, weight;
		public Node(int y, int x, int weight) {
			this.y = y;
			this.x = x;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int[][] dr = {{0,1}, {1,0}};
	static boolean isOut(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= n;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		
		visit = new boolean[n][n];
		dij = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				dij[i][j] = Integer.MAX_VALUE;
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		que.add(new Node(0,0, 0));
		dij[0][0] = 0;
		
		while (!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.y][now.x]) continue;
			visit[now.y][now.x] = true;
			
			for (int i = 0; i < 2; i++) {
				int y = now.y + dr[0][i];
				int x = now.x + dr[1][i];
				
				if (isOut(y,x)) continue;
				
				int weight = map[y][x]+1-map[now.y][now.x];
				if (weight < 0) weight = 0;
				int summ = now.weight + weight;
				
				
				if (summ < dij[y][x]) {
					if (!visit[y][x]) que.add(new Node(y,x, summ));
					dij[y][x] = summ;
				}
			}
		}
		
		System.out.println(dij[n-1][n-1]);
		
	}
}
