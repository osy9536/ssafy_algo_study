package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1261 {
	static int n;
	static int m;

	static int INF = Integer.MAX_VALUE;

    static int[][] map;
	static int[][] dij;
	static boolean[][] visit;
	static Queue<Node> que = new PriorityQueue<>();

    static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
    
    static boolean isOut(int y, int x) {
    	return y < 0 || y >= n || x < 0 || x >= m;
    }
	
	static class Node implements Comparable<Node> {
		int y,x, weight;

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		

		map = new int[n][m];
		dij = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dij[i][j] = INF;
			}
		}
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}

		dij[0][0] = 0;
		que.add(new Node(0,0,0));

		while (!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.y][now.x]) continue;
			visit[now.y][now.x] = true;
			for (int i = 0; i < 4; i++) {
				int y = now.y + dr[0][i];
				int x = now.x + dr[1][i];
				
				if (isOut(y,x)) continue;
				
				int len = now.weight;
				if (map[y][x] == 1) len++;
				
				if (dij[y][x] > len) {
					if (!visit[y][x]) que.add(new Node(y,x,len));
					dij[y][x] = len;
						
				}
			}
		}

		System.out.println(dij[n-1][m-1]);

	}
}
