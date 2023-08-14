import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1012 {
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int M; static int N; static int K;
	static int my[][]; static boolean visited[][];
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			my = new int[M][N];
			visited = new boolean[M][N];
			//배추위치 저장
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				my[m][n] = 1;
			}
			//배추위치 순회하면서 DFS진행
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(my[i][j] == 1 && !visited[i][j]) {				 
						 ans++;
						 DFS(i, j);							
					}
				}
			}
			System.out.println(ans);
		}
	}
	static void DFS(int i, int j) {
		visited[i][j] = true;
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k]; int ny = j + dy[k];
			if(0 <= nx && nx < M && 0 <= ny && ny < N) {
				if(my[nx][ny] == 1 & !visited[nx][ny]) {
					DFS(nx, ny);
				}
			}
		}
	}
}
