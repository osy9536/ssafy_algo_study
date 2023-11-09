package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 1261
 * 알고스팟
 * 골드 4
 * https://www.acmicpc.net/problem/1261
 */
public class b1261 {
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(cost, o.cost);
		}
		
	}
	
	static int n; // width
	static int m; // height
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //column
		m = Integer.parseInt(st.nextToken()); //row
		
		char[][] maze = new char[m][n];
		
		for(int i = 0; i < m; i++) {
			maze[i] = br.readLine().toCharArray();
		}
		
		System.out.println(dijkstra(maze, n, m));
	}
	
	public static int dijkstra(char[][] maze, int n, int m) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>(); //r, c, cost
		pq.add(new Node(0, 0, 0));
		int[][] distance = new int[m][n];
		for(int i = 0 ; i < m; i++) {
			for(int j = 0; j < n; j++) {
				distance[i][j] = 100001;
			}
		}
		
		distance[0][0] = 0;
		
		while(!pq.isEmpty()) {

			Node cur = pq.poll();
			
			if(cur.x == m - 1 && cur.y == n - 1)
				return distance[m - 1][n - 1];
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;
				
				if(cur.y > distance[nx][ny])
					continue;
				
				int tempCost = 0;
				if(maze[nx][ny] == '1')
					tempCost = 1;
				
				if(distance[nx][ny] > distance[cur.x][cur.y] + tempCost) {
					distance[nx][ny] = distance[cur.x][cur.y] + tempCost;
					pq.add(new Node (nx, ny, distance[nx][ny]));
				}
			}
		}
		
		return -1;
	}
}

