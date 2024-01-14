package algorithm.src.jisu;
import java.io.*;
import java.util.*;

public class b22116 {
	static int n, result;
	static int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] dij;
	static boolean[][] visit;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
	
	public static boolean isOut(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= n;
	}
	
	static class Node implements Comparable<Node> {
		int y, x, weight;
		public Node(int y, int x, int weight) {
			this.y = y;
			this.x = x;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		
		map = new int[n][n];
		dij = new int[n][n];
		visit = new boolean[n][n];
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dij[i][j] = INF;
			}
		}
		
		Queue<Node> que = new PriorityQueue<>();
		que.add(new Node(0,0,0));
		dij[0][0] = 0;
		
		while (!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.y][now.x]) continue;
			visit[now.y][now.x] = true;
			for (int i = 0; i < 4; i++) {
				int y = now.y + dr[0][i];
				int x = now.x + dr[1][i];
				if (isOut(y,x)) continue;
				int len = Math.abs(map[y][x] - map[now.y][now.x]);
				int maxi = Math.max(now.weight, len);
				if (dij[y][x] > maxi) {
					if (!visit[y][x]) que.add(new Node(y,x,maxi));
					dij[y][x] = maxi;
				}
			}
		}
		
		System.out.println(dij[n-1][n-1]);
	}
}
