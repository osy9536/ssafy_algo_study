package algorithm.src.jaeyun;

import java.util.Scanner;

public class b03474 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 0; tc<T; tc++) {
			int N = sc.nextInt();
			int ans = 0;
			for (int i=5; i<=N; i *= 5) {
				ans += N/i;
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
