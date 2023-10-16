package algorithm.src.ohseyoung;

import java.util.Scanner;

public class b1309 {
	static final int MOD = 9901;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[][] dp = new long[n + 1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1; // 기저 사례
		
		// j = 0 : 아무 동물도 놓지 않음
		// j = 1 : 첫 번째 칸에 동물을 놓음
		// j = 2 : 두 번째 칸에 동물을 놓음
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
		}

		long ans = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
		System.out.println(ans);
	}
}
