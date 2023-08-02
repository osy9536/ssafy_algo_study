package algorithm.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14501 
 * 퇴사
 * 실버3
 * https://www.acmicpc.net/problem/14501
 */
public class b14501 {
	
	private static class Consult {
		int t;
		int p;
		
		public Consult(int t, int p) {
			this.t = t;
			this.p = p;
		}
		
		public int getT() {
			return t;
		}
		
		public int getP() {
			return p;
		}
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Consult[] consults = new Consult[n + 1];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			consults[i] = new Consult(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		
		int[] dp = new int[n + 1];
		for(int i = 0; i < n; i++) {
			if(i + consults[i].getT() < n + 1) {
				dp[i + consults[i].getT()] = 
						Math.max(dp[i + consults[i].getT()], dp[i] + consults[i].getP());
			}
			
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		
		System.out.println(dp[n]);
		
		
	}

}
