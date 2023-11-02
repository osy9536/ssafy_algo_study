package algorithm.src.junseo

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
        long start = 0;
		long end = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
			if(start<arr[i]) start = arr[i];
			end += arr[i];
		}

		while (end >= start) {
			int mid = (int) ((end + start) / 2);

			long res = cal(mid);

			if (res > M) {
				start = mid + 1;
			}

			else if (res <= M) {
				end = mid - 1;
			}

		}
		System.out.println(start);

	}

	private static long cal(long mid) {
		
		long cnt=1;
		long sum= 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if(sum>mid) {
				sum = arr[i];
				cnt++;
			}
		}
		return cnt;
	}
}

