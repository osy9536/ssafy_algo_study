package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][N];
		for (int i=0; i<N; i++) {
			dp[i][0] = map[i][0];
			for (int j=1; j<N; j++) {
				dp[i][j] = dp[i][j-1] + map[i][j];
			}
		}
		for (int i=0; i<N; i++) {
			for (int j=1; j<N; j++) {
				dp[j][i] += dp[j-1][i];
			}
		}
//		System.out.println(Arrays.deepToString(dp));
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			int c1 = dp[x2][y2];
			int c2 = (x1 - 1 < 0) ? 0 : dp[x1-1][y2];
			int c3 = (y1 - 1 < 0) ? 0 : dp[x2][y1-1];
			int c4 = (x1 - 1 < 0 || y1 - 1 < 0) ? 0 : dp[x1-1][y1-1];
			System.out.println(c1 - c2 - c3 + c4);
		}
		br.close();
	}
}
