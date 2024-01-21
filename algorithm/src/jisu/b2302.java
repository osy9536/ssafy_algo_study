package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b2302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] arr = new int[m+1];
		for (int i = 1; i <= m; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		long answer = 1;
		for (int i = 1; i <= m; i++) {
			int vip = arr[i] - arr[i-1] - 1;
			
			answer *= dp[vip];
		}
		
		answer *= dp[n-arr[m]];
		
		System.out.println(answer);
	}
}
