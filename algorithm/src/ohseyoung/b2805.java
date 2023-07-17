package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//  나무 자르기
public class b2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int min = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (max < arr[i])
				max = arr[i];
		}

		// 20 15 10 17
		// 10 15 17 20

		// 22
		while (min < max) {
			long sum = 0;
			int mid = (max + min) / 2;
			for (int i : arr) {
				if (i - mid > 0)
					sum += i - mid;
			}

			if (sum < m) {
				max = mid;
			} else {
				min = mid + 1;
			}

			// min = 12, mid = 16 -> max = 16, mid = 14 -> min = 14, mid = 15 -> max =15,
			// min = 15
		}
		System.out.println(min - 1);
	}
}
