package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2294 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[k+1];
		Arrays.fill(dp,100001);
		
		dp[0] = 0;
		
		for(int i = 0 ; i < n; i++) {
			for(int j = c[i]; j<=k ; j++) {
				dp[j] = Math.min(dp[j],dp[j - c[i]]+1);
			}
		}
		System.out.println(dp[k]==100001 ? -1 : dp[k]);
	}
}