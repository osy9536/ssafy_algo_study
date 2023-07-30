package algorithm.src.jaeyun;

import java.util.Scanner;

public class b02798 {
	static int N, M, ans;
	static int[] blackjack;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		blackjack = new int[N];
		result = new int[3];
		for (int i=0; i<N; i++) {
			blackjack[i] = sc.nextInt();
		}
		
		combination(0, 0);
		System.out.println(ans);
		sc.close();
	}
	static void combination(int cnt, int start) {
		if (cnt == 3) {
			int sum = result[0] + result[1] + result[2];
			if (sum <= M && sum > ans) ans = sum;
			return;
		}
		for (int i=start; i<N; i++) {
			result[cnt] = blackjack[i];
			combination(cnt+1, i+1);
		}
	}
}
