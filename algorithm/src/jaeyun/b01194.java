package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b01194 {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		char [][] map = new char[N][M];
		char[] tmp = null;
//		boolean[] key = new boolean[6];
		int cur_x = 0, cur_y = 0;
		
		for (int i=0; i<N; i++) {
			tmp = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = tmp[j];
				if (map[i][j] == '0') {
					cur_x = i;
					cur_y = j;
				}
			}
		}
//		System.out.println(Arrays.deepToString(map));
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[cur_x][cur_y] = true;
		q.add(new Pair(cur_x, cur_y, visited, new boolean[6]));
		map[cur_x][cur_y] = '.';
		
		int ans = 0;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i=0; i<qsize; i++) {
				Pair pair = q.poll();
//				System.out.println(pair);
				if (map[pair.x][pair.y] == '1') {
					System.out.println(ans);
					return;
				}
				
				for (int d=0; d<4; d++) {
					int nx = pair.x + dx[d];
					int ny = pair.y + dy[d];
					if (nx<0 || ny<0 || nx>N-1 || ny>M-1) continue;
					if (pair.visited[nx][ny]) continue;
					if (map[nx][ny] == '#') continue;
					if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F' && !pair.key[map[nx][ny] - 'A']) continue;
					
					boolean[][] newVisited = new boolean[N][M];
					for (int j=0; j<N; j++) {
						newVisited[j] = Arrays.copyOf(pair.visited[j], M);
					}
					boolean[] newKey = new boolean[6];
					newKey = Arrays.copyOf(pair.key, 6);
					
					if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
						newKey[map[nx][ny] - 'a'] = true;
						newVisited = new boolean[N][M];
					}
					if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') map[nx][ny] = '.';
					
					newVisited[nx][ny] = true;
//					System.out.println("newVisited: "+Arrays.deepToString(newVisited));
					q.add(new Pair(nx, ny, newVisited, Arrays.copyOf(newKey, 6)));
					
					
				}
			}
			ans += 1;
		}
		
		
		
		System.out.println(-1);
	}
	private static class Pair {
		int x, y;
		boolean[][] visited;
		boolean[] key;
		Pair(int x, int y, boolean[][] visited, boolean[] key){
			this.x = x;
			this.y = y;
			this.visited = visited;
			this.key = key;
		}
		@Override
		public String toString() {
			return "Pair [" + x + ", " + y + "\tvisited=" + Arrays.deepToString(visited)
					+ ", key="
					+ Arrays.toString(key)
					+ "]";
		}
	}
}
