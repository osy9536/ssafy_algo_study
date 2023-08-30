import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr, dp;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ans = Math.max(dfs(i, j), ans);
			}
		}
		System.out.println(ans);
	}
	static int dfs(int stx, int sty) {
		if(dp[stx][sty] != 0) return dp[stx][sty];
		
		dp[stx][sty] = 1;
		for(int k = 0; k < 4; k++) {
			int nx = stx + dir[k][0];
			int ny = sty + dir[k][1];
			if(0 <= nx && nx < n && 0 <= ny && ny < n) {
				if(arr[stx][sty] < arr[nx][ny]) {
					dp[stx][sty] = Math.max(dp[stx][sty], dfs(nx, ny)+1);
					dfs(nx, ny);
				}
			}
		}
		return dp[stx][sty];
	}
}
