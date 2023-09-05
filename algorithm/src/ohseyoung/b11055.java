package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 증가하는 부분 수열
// silver 2
public class b11055 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int dp[] = new int[N + 1];
		int map[] = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 값입력
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			dp[i] = map[i];
		}

		// 값이 하나 주어질 때 대비
		int result = dp[1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (map[j] < map[i]) {
					dp[i] = Math.max(dp[j] + map[i], dp[i]);
					result = Math.max(result, dp[i]);
				}
			}
		}
		System.out.println(result);
	}
}
