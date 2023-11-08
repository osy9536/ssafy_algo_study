package algorithm.src.minho;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{

	int x;
	int y;
	int cnt;

	public Node(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Node o) {
		if(this.cnt==o.cnt)
			return (o.x+o.y)-(this.x+this.y);
		else return this.cnt-o.cnt;
	}
}

public class b2665 {

	static int N;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Node[][] count;
	static boolean[][] isVisited;

	static void BFS() {
		PriorityQueue<Node> q = new PriorityQueue();
		q.add(new Node(0, 0, 0));

		while (!q.isEmpty() || !isVisited[N-1][N-1]) {
			Node current = q.poll();
			isVisited[current.x][current.y]=true;
			for (int i = 0; i < 4; i++) {
				int cx = current.x + dx[i];
				int cy = current.y + dy[i];
				if (cx < N && cy < N && cx>=0 && cy>=0) {
					if(isVisited[cx][cy]) continue;
					int cc = current.cnt;
					if (map[cx][cy] == 0) cc++;
					if (count[cx][cy] == null || count[cx][cy].cnt > cc) {
						count[cx][cy] = new Node(cx, cy, cc);
						q.add(new Node(cx, cy, cc));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = new Node[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		BFS();
		
		System.out.println(count[N-1][N-1].cnt);
	}
}