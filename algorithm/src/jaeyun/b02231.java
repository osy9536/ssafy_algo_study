package algorithm.src.jaeyun;

import java.util.Scanner;

public class b02231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = 1;
		while (N >= M) {
			int ans = M;
			// calculate 'separate sum'
			int div = M;
			while (div > 0) {
				ans += div % 10;
				div /= 10;
			}
			if (ans == N) {
				System.out.println(M);
				sc.close();
				return;
			}
			M++;
		}
		System.out.println(0);
		sc.close();
	}
	/*
	 * time complexity(max): 10**6 * 6   <<   10**9
	 */
}
