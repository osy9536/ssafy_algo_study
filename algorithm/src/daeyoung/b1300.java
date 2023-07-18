package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/**
 * 백준 1300
 * K번째 수
 * 골드2
 * https://www.acmicpc.net/problem/1300
 */
public class b1300 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = k;
		int mid;
		while (start < end) {
			
			mid = (start + end) / 2;
			
			if(countNum(n, mid) < k) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		
		System.out.println(start);
		
	}
	
	public static long countNum (int n, int mid) {
		long count = 0;
		
		for(int i = 1; i <= n; i++)
			count += Math.min(mid / i, n);
		
		return count;
	}

}
