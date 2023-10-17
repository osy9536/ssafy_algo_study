package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 2302
 * 극장 좌석
 * https://www.acmicpc.net/problem/2302
 */
public class b2302 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 좌석 개수
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 고정석 개수
		
		int[] fixed = new int[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			fixed[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp  = new int[n + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		if(n > 2)
			dp[2] = 2;
		
		for(int i = 3; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		int answer = 1;
		int pre = 0;
		for(int i = 0; i < m; i++) {
			answer *= dp[fixed[i] - pre - 1];
			pre = fixed[i];
		}
		
		answer *= dp[n - pre];
		
		System.out.println(answer);
		
	}
}

