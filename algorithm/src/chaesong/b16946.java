import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr, group;
	static boolean visit[][];
	static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static HashMap<Integer, Integer> hm = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		group = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		int groupCnt = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0 && group[i][j] == 0) {
					hm.put(groupCnt, bfs(i, j, groupCnt));
					groupCnt++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(group[i][j] == 0) {
					sb.append(count(i, j));
					continue;
				}
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static int count(int x, int y) {
		int cnt = 1;
		if(arr[x][y] == 0) return 0;
		Set<Integer> set = new HashSet<>();
		for(int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			if(0 <= nx && nx < N && 0 <= ny && ny < M) {
				if(group[nx][ny] != 0) set.add(group[nx][ny]);
			}
		}
		for(int size: set) cnt += hm.get(size);
		return cnt%10;
	}
	static int bfs(int stx, int sty, int groupCnt) {
		Queue<int[]> q = new LinkedList<>();
		int now[] = {stx, sty};
		q.add(now);
		int cnt = 1;
		group[stx][sty] = groupCnt;
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			for(int k = 0; k < 4; k++) {
				int nx = temp[0] + dir[k][0];
				int ny = temp[1] + dir[k][1];
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(group[nx][ny] == 0 && arr[nx][ny] == 0) {
						group[nx][ny] = groupCnt;
						int next[] = {nx, ny};
						q.add(next);
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
