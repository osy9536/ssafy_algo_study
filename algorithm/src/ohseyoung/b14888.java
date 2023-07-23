package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14888 {
	static int max = Integer.MIN_VALUE; // 결과의 최댓값 초기화
	static int min = Integer.MAX_VALUE; // 결과의 최솟값 초기화
	static int[] num;
	static int[] four = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			four[i] = Integer.parseInt(st.nextToken()); // 입력 끝

		find(num[0], n - 1);
		System.out.println(max);
		System.out.println(min);
	}

	public static void find(int start, int cnt) { // (결과, 카운트)
		if (cnt == 0) { // 연산 끝나면 최대, 최소 판단
			max = Math.max(max, start);
			min = Math.min(min, start);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (four[i] > 0) {
				four[i]--;
				switch (i) {
				case 0:
					find(start + num[num.length - cnt], cnt - 1);
					break;
				case 1:
					find(start - num[num.length - cnt], cnt - 1);
					break;
				case 2:
					find(start * num[num.length - cnt], cnt - 1);
					break;
				case 3:
					find(start / num[num.length - cnt], cnt - 1);
					break;
				}
				four[i]++;
			}
		}
	}
}
