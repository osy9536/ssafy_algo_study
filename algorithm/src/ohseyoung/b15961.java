package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 회전 초밥
// gold 4
public class b15961 {
	static int N, c, k;
	static int[] sushiCnt, list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushiCnt = new int[d + 1]; // 각 물품별 개수를 기록할 배열

		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(slide());

	}

	private static int slide() {
		int max = 0;
		int total = 0;
		for (int i = 0; i < k; i++) {
			if (sushiCnt[list[i]] == 0)
				total++;
			sushiCnt[list[i]]++;
		}
		max = total;

		for (int i = 1; i < N; i++) {
			sushiCnt[list[i - 1]]--;
			if (sushiCnt[list[i - 1]] == 0)
				total--;
			if (sushiCnt[list[(i + k - 1) % N]] == 0)
				total++;
			sushiCnt[list[(i + k - 1) % N]]++;
			if (max <= total) {
				if (sushiCnt[c] == 0)
					max = total + 1;
				else
					max = total;
			}
		}
		return max;
	}
}
