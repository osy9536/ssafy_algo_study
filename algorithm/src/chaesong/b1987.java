import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1987 {
	static int R, C;
	static char[][] arr;
	static boolean[] visit;
	static int[][] dist;
	static int MAX;
	static int dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visit = new boolean[26];
		dist = new int[R][C];
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		MAX = 0;
		dist[0][0] = 1;
		dfs(0, 0);
		System.out.println(MAX);
	}
	static void dfs(int stx, int sty) {
		visit[arr[stx][sty] - 65] = true; //자기거도 방문 처리 해주고
		MAX = MAX < dist[stx][sty]? dist[stx][sty] : MAX; //max값이랑 비교
		
		for(int k = 0; k < 4; k++) {
			int nx = stx + dir[k][0];
			int ny = sty + dir[k][1];
			if(0 <= nx && nx < R && 0 <= ny && ny < C) { //범위 내에 있고
				if(!visit[arr[nx][ny] - 65]) { //방문한 적 없다면
					visit[arr[nx][ny] - 65] = true;
					dist[nx][ny] = dist[stx][sty] + 1;
					dfs(nx, ny);
					visit[arr[nx][ny] - 65] = false;
				}
			}
		}
	}
}
