package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 스티커
// silver 1
public class b9465 {
	static int[][] sticker;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sticker = new int[2][n];
			int[][] dp = new int[2][n];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(n<2) {
				System.out.println(Math.max(sticker[0][0], sticker[1][0]));
				continue;
			}
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			dp[0][1] = sticker[1][0] + sticker[0][1];
			dp[1][1] = sticker[0][0] + sticker[1][1];
			for (int j = 2; j < n; j++) {
				dp[0][j] = Math.max(dp[1][j - 2] + sticker[0][j], dp[1][j - 1] + sticker[0][j]);
				dp[1][j] = Math.max(dp[0][j - 2] + sticker[1][j], dp[0][j - 1] + sticker[1][j]);
			}
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
	}
}
