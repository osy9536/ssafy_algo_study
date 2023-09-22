
package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b17626{
	static int[] e = new int[225];
	static int N , check=0,save;
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 5;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.print(dp[n]);
    }
}