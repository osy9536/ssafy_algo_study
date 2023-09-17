package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class XY {
	int x, y;

	public XY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class b2178 {
	static int N ,M, count=0;
	static int[][] map;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean[][] isVisited;

	public static void BFS() {
		isVisited[0][0] = true;
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(0, 0));
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				XY lo = q.poll();
				if(lo.x == N-1 && lo.y == M-1)
					return;
				for (int d = 0; d < 4; d++) {
					if(lo.x+dx[d]<N && lo.y+dy[d]<M && lo.x+dx[d]>=0 && lo.y+dy[d]>=0 
							&& !isVisited[lo.x+dx[d]][lo.y+dy[d]] && map[lo.x+dx[d]][lo.y+dy[d]]==1) {
						isVisited[lo.x+dx[d]][lo.y+dy[d]]=true;
						q.add(new XY(lo.x+dx[d],lo.y+dy[d]));
					}
				}
			}
			count++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		// 입력끝
		BFS();
		System.out.println(count+1	);
	}
}
/*
 * 1 2 2 0 0 0 0
 */