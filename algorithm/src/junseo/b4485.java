package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	int x,y,cost;

	public Node(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
	
}

public class Main {
	static final int INF = Integer.MAX_VALUE; 
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int problemNum = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			int[][] arr = new int[N][N];
			int[][] dis = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dis[i][j] = INF;
				}
			}
			dis[0][0] = arr[0][0];
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0,0,dis[0][0]));
			
			while(!pq.isEmpty()) {
				Node currentNode = pq.poll();
				
				if(currentNode.cost > dis[currentNode.x][currentNode.y]) continue;
				
				for (int i = 0; i < 4; i++) {
					int nx = currentNode.x + dx[i];
					int ny = currentNode.y + dy[i];
					
					if(nx>=0 && nx <N && ny>=0 && ny<N) {
						int newCost = dis[currentNode.x][currentNode.y] + arr[nx][ny];
						
						if(newCost < dis[nx][ny]) {
							dis[nx][ny] = newCost;
							pq.offer(new Node(nx,ny,newCost));
						}
						
					}
					
				}
				
			}
			
			sb.append("Problem " + problemNum + ": " + dis[N-1][N-1]).append("\n");
			problemNum++;
		}	
		System.out.println(sb);
	}
}


