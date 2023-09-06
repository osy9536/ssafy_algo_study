package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 감소하는 부분 수열
// silver 2
public class b11722 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[A];
		for(int i = 0; i<A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[A+1];
		int max = 1;
		dp[0]=1;
		for(int i = 1; i<A; i++) {
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(arr[j]>arr[i]&&dp[j]>=dp[i]) {
					dp[i]=dp[j]+1;
					max = Math.max(dp[i], max);
				}
			}
		}
		System.out.println(max);
	}
}
