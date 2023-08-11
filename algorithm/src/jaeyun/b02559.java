package algorithm.src.jaeyun;

import java.util.Scanner;

public class b02559 {
	public static void main(String[] args) {
		int ans = Integer.MIN_VALUE;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[100000];
		int[] psum = new int[100001];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		psum[0] = 0;
		psum[1] = arr[0];
		for (int i = 1; i < N; i++) {
			psum[i+1] = psum[i] + arr[i];
		}
		
		for (int i = 0; i < N + 1 - K; i++) {
			int tmp = psum[i + K] - psum[i];
			if (tmp > ans) {
				ans = tmp;
			}
		}
		
		System.out.println(ans);
	}
}
