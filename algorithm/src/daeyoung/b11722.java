package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 11722
 * 가장 긴 감소하는 부분 수열
 * 실버2
 * https://www.acmicpc.net/problem/11722
 */
public class b11722 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] ary = new int[n];
		for(int i = 0; i < n; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(ary[i] < ary[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		
		int max = dp[0];
		for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
		
	}
}
