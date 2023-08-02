package algorithm.jaeyun;

import java.util.PriorityQueue;
import java.util.Scanner;

public class b15903 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int i=0; i<N; i++) {
			pq.add(sc.nextLong());
		}
		for (int i=0; i<M; i++) {
			long sum = pq.poll() + pq.poll();
			pq.add(sum); pq.add(sum);
		}
		long ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}
		System.out.println(ans);
		sc.close();
	}
}
