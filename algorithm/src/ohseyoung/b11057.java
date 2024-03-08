package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 오르막 수
// silver 1
public class b11057 {
    static int dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % 10007);
    }
}
