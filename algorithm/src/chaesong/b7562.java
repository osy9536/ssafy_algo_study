import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int dx[] = {-2, -1, 2, 1, -2, -1, 1, 2};
	static int dy[] = {1, 2, 1, 2, -1, -2, -2, -1};
	static int N;
	static int arr[][];
	static int visit[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			int stX = sc.nextInt(); int stY = sc.nextInt();
			int endX = sc.nextInt(); int endY = sc.nextInt();
			visit = new int[N][N];
			int ans = BFS(stX, stY, endX, endY);
			if (stX == endX && endX == endY) ans = 0;
			System.out.println(ans);
		}
	}
	static int BFS(int stX, int stY, int endX, int endY) {
		Queue<int[]> q = new LinkedList<>();
		int start[] = {stX, stY};
		q.add(start);
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			for(int i = 0; i < 8; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(visit[nx][ny] == 0) {
						int now[] = {nx, ny};
						q.add(now);
						visit[nx][ny] = visit[temp[0]][temp[1]] + 1;
					}
					if(nx == endX && ny == endY) {
						return visit[nx][ny];
					}
				}
			}
		}
		return 0;
	}
}
