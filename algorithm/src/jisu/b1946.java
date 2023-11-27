package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1946 {
	static class Cand implements Comparable<Cand> {
		int a , b;
		public Cand(int a, int b ) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Cand o) {
			if (this.a == o.a) return this.b - o.b;
			return this.a - o.a;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int result = 1;
			List<Cand> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Cand(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list);
			int mini = list.get(0).b;
			for (int i = 1; i < n; i++) {
				Cand now = list.get(i);
				if (mini > now.b) {
					result++;
					mini = now.b;
				}
			}
			System.out.println(result);
		}

	}
}
