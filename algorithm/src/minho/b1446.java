package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Road implements Comparable<Road> {
	int start;
	int end;
	int val;

	public Road(int start, int end, int val) {
		this.start = start;
		this.end = end;
		this.val = val;
	}

	@Override
	public int compareTo(Road o) {
		if (this.start == o.start)
			return this.end - o.end;
		return this.start - o.start;
	}

}

public class b1446 {

	static int N, D;
	static PriorityQueue<Road> pq;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (e - s < v || e > D)
				continue;
			else
				pq.add(new Road(s, e, v));

		}
		int move = 0;
		int[] dist = new int[D + 1];
		Arrays.fill(dist, D + 1);
		dist[0] = 0;
		while (move < D) {
			if (!pq.isEmpty()) {
				Road r = pq.peek();
				if (move == r.start) {
					dist[r.end] = Math.min(dist[move] + r.val, dist[r.end]);
					pq.poll();
				} else {
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
				}
			} else {
				dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
				move++;
			}

		}
		System.out.println(dist[D]);
	}
}