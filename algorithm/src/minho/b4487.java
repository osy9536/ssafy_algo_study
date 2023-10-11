package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class b4487{
	static class Node implements Comparable<Node>{
		int x, y, w;

		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	
	static int N;
	static int[][] map;
	static int[][] dijk;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static boolean isValid(int nx, int ny) {
		if(nx>=0 && nx<N && ny>=0 && ny<N)
			return true;
		return false;
	}
	public static int dijkstra()  {
		PriorityQueue<Node> q = new PriorityQueue<>(); 
		dijk[0][0] = map[0][0];
		q.offer(new Node(0,0,map[0][0]));
		
		while(!q.isEmpty()) {
			if(dijk[N-1][N-1]!=Integer.MAX_VALUE) break;
			Node p = q.poll();
			for(int d = 0 ; d < 4 ; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(isValid(nx,ny)) {
					if(dijk[nx][ny]>dijk[p.x][p.y]+map[nx][ny]) {
						dijk[nx][ny] = dijk[p.x][p.y]+ map[nx][ny];
						q.offer(new Node(nx,ny,dijk[nx][ny]));
					}
				}
			}
		}
				
		return dijk[N-1][N-1];
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			cnt++;
			map = new int[N][N];
			dijk = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dijk[i][j] = Integer.MAX_VALUE;
				}
			}
			System.out.println("Problem "+cnt+": "+dijkstra());
		}
	}
}