package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 철로
// gold 2
public class b13334 {
	static class Pair implements Comparable<Pair> {
		int s, e;

		Pair(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Pair o) {
			return this.e-o.e;
		}
	}

	static Pair[] pairs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		pairs = new Pair[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}

			pairs[i] = new Pair(a, b);
		}
		int dis = Integer.parseInt(br.readLine());

		Arrays.sort(pairs);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			Pair info = pairs[i];
			if (info.e - info.s > dis)
				continue;

			pq.add(info.s);
			while (!pq.isEmpty()) {
				if (info.e - pq.peek() <= dis)
					break;
				pq.poll();
			}
			answer = Math.max(answer, pq.size());
		}
		System.out.println(answer);
	}
}
