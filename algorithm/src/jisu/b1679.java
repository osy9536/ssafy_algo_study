package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1679 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		int k = Integer.parseInt(br.readLine());
		
		int[] dp = new int[arr[n-1]*k+2];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i = 1; i < dp.length; i++) {
			if (set.contains(i)) {
				dp[i] = 1;
			} else {
				for (int j = 1; j <= i/2; j++) {
					dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
				}
			}
			
			if (dp[i] > k) {
				StringBuilder sb = new StringBuilder();
				if (i % 2 == 0) {
					sb.append("hol");
				} else sb.append("jjak");
				
				sb.append("soon win at ");
				sb.append(i);
				System.out.println(sb.toString());
				break;
			}
		}
	}
}
