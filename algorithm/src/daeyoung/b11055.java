package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 11055
 * 가장 큰 증가하는 부분 수열
 * 실버2
 * https://www.acmicpc.net/problem/11055
 */
public class b11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] ary = new int[n];
		for(int i = 0; i < n; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			dp[i] = ary[i];
			for(int j = 0; j < i; j++) {
				if(ary[i] > ary[j]) {
					dp[i] = Math.max(dp[j] + ary[i], dp[i]);
				}
			}
		}
		
		int max = dp[0];
		for(int i = 1; i < n; i++) {
			max = Math.max(dp[i], max);
		}
		
		
		System.out.println(max);
	}
}
