package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b11729 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>( (o1, o2)-> o2-o1 );
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			if (m == 0) {
				if (que.size() == 0) System.out.println(0);
				else System.out.println(que.poll());
			} else que.add(m);
		}

	}
}
