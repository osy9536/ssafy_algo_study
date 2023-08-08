package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class b1697 {
	public static boolean isin (int x) {
		if (x<0 || x > 100000) return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if (n==k) System.out.println(0);
		else {
			Queue<Integer> que = new LinkedList<Integer>();
			Queue<Integer> cnt = new LinkedList<Integer>();
			Set<Integer> visit = new HashSet<>();
			
			int[] first = new int[] {2*n, n-1, n+1};
			for (int h: first) {
				if (isin(h)) {
					que.add(h);
					visit.add(h);
					cnt.add(1);
				}
			}
			visit.add(n);

			while (!que.isEmpty()) {
				int now = que.poll();
				int c = cnt.poll();
				
				if (now == k) {
					System.out.println(c);
					break;
				}

				int[] hubo = new int[] {2*now, now-1, now+1};
				for (int h: hubo) {
					if (isin(h) && !visit.contains(h)) {
						que.add(h);
						visit.add(h);
						cnt.add(c+1);
					}
				}
				
				
			}

		}
	}
}

