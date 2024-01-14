package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		int arrLim = n;
		int add = 0;
		for (int i = 0; i < arr.length; i++) {
			add += i;
			if (add > n) {
				arrLim = i;
				break;
			}
			arr[i] = add;
		}
		
		int[] jack = new int[arrLim];
		add = 0;
		for (int i = 0; i < arrLim; i++) {
			add += arr[i];
			jack[i] = add;
		}
		
		int result = n;
		
		
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = n;
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < arrLim; j++) {
				if (jack[j] > i) break;
				if (jack[j] == i) {
					dp[i] = 1;
				}
				if (jack[j] < i) dp[i] = Math.min(dp[i], dp[i-jack[j]]+1);
			}
		}
		
		
		System.out.println(dp[n]);
	}
}
