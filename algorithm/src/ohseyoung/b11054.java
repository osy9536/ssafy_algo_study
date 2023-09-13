package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분 수열
// gold 4
public class b11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] l_dp = new int[N];
		int[] r_dp = new int[N];
		int answer = 0;
		if(N==1) {
			System.out.println(1);
			return;
		}
		for(int i = 0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i]= a;
		}
		for (int i = 0; i < N; i++) {
		    l_dp[i] = 1; 
		    r_dp[i] = 1; 
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<i; j++) {
				if(arr[j]<arr[i] && l_dp[j] >= l_dp[i]) {
					l_dp[i]=l_dp[j]+1;
				}
			}
		}
		for (int i = N - 1; i >= 0; i--) {
		    for (int j = N - 1; j >= i; j--) {
		        if (arr[j] < arr[i] && r_dp[j] + 1 >= r_dp[i]) {
		            r_dp[i] = r_dp[j] + 1;
		        }
		    }
		}
		
		for(int i = 0; i<N; i++) {
			answer = Math.max(l_dp[i] + r_dp[i] - 1,answer);
		}
		System.out.println(answer);
	}
}
