package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b4485 { 
	static int n;	
	static int INF = Integer.MAX_VALUE;
	
    static int[][] map;
	static int[][] dij;
    static boolean[][] visit;
    static Queue<Node> que = new PriorityQueue<>();
    
    static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
    
    static boolean isOut(int y, int x) {
    	return y < 0 || y >= n || x < 0 || x >= n;
    }
    
    static class Node implements Comparable<Node> {
    	int y,x, weight;
    	
    	
    	public Node(int y, int x, int weight) {
			super();
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

		int tc = 1;
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
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
			
			que.clear();
			que.add(new Node(0, 0, map[0][0]));
			dij[0][0] = map[0][0];
			
			while(!que.isEmpty()) {
				Node now = que.poll();
				if (visit[now.y][now.x]) continue;
				visit[now.y][now.x] = true;
				for (int i = 0; i < 4; i++) {
					int y = now.y + dr[0][i];
					int x = now.x + dr[1][i];
					if (isOut(y,x)) continue;
					int len = now.weight + map[y][x];
					if (dij[y][x] <= len) continue;
					if (!visit[y][x]) que.add(new Node(y,x,len));
					dij[y][x] = len;
				}
			}
			
			System.out.println("Problem " + tc++ + ": " + dij[n-1][n-1]);
		}

	}
}
