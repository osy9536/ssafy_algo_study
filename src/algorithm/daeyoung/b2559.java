package algorithm.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 2559 
 * 수열
 * 실버3
 * https://www.acmicpc.net/problem/2559
 */
public class b2559 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//온도 측정 날짜
		int n = Integer.parseInt(st.nextToken());
		//연속 날짜
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n + 1; i++) {
			dp[i] += dp[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = k; i < n + 1; i++) {
			int temp = dp[i] - dp[i - k];
			
			if(max < temp)
				max = temp;
		}
		
		System.out.println(max);
		
	}

}
