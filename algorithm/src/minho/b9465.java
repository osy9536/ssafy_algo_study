package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9465 {

	static int[][] DP, map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[2][N];
			DP = new int[2][N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[1][i] = Integer.parseInt(st.nextToken());
			}

			DP[0][0] = map[0][0];
			DP[1][0] = map[1][0];

			for (int i = 1; i < N; i++) {
				if (i >= 2) {
					int go = Math.max(DP[0][i - 2], DP[1][i - 2]);
					DP[0][i] = Math.max(map[0][i] + go, map[0][i] + DP[1][i - 1]);
					DP[1][i] = Math.max(map[1][i] + go, map[1][i] + DP[0][i - 1]);
				} else {
					DP[0][i] = map[0][i] + DP[1][i - 1];
					DP[1][i] = map[1][i] + DP[0][i - 1];
				}
			}

			System.out.println(Math.max(DP[0][N - 1], DP[1][N - 1]));
		}
	}

}