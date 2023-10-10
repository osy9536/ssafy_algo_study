package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1584 { 
	static int n;
	static int m;
	static int f;
	
	static int INF = Integer.MAX_VALUE;
	
    static int[][] map;
    static boolean[] visit;
    static List<List<Node>> list = new ArrayList<>();
    
    static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
    
    static boolean isOut(int y, int x) {
    	return y < 0 || y >= 501 || x < 0 || x >= 501;
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
		map = new int[501][501];
		for (int k = 0; k < n; k++) {
			st = new StringTokenizer(br.readLine());
			int x1, x2, y1, y2;
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			
			for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
				for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
					map[i][j] = 1;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int x1, x2, y1, y2;
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			
			for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
				for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
					map[i][j] = INF;
				}
			}
		}
		
		int result = -1;
		
		boolean[][] visit = new boolean[501][501];
		int[][] dij = new int[501][501];
		
		PriorityQueue<Node> que = new PriorityQueue<>();

		for (int i = 0; i < 501; i++) {
			for (int j = 0; j < 501; j++) {
				dij[i][j] = INF;
			}
		}

		que.add(new Node(0, 0, 0));
		dij[0][0] = 0;
		
		while (!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.y][now.x]) continue;
			visit[now.y][now.x] = true;
			
			for (int i = 0; i < 4; i++) {
				int y = now.y + dr[0][i];
				int x = now.x + dr[1][i];
				if (isOut(y,x) || map[y][x] == INF) continue;
				int weight = now.weight + map[y][x];
				if (dij[y][x] > weight) {
					if (!visit[y][x]) que.add(new Node(y,x,weight));
					dij[y][x] = weight;
				}
			}
		}
		
		if (dij[500][500] == INF) System.out.println(-1);
		else System.out.println(dij[500][500]);

	}
}
