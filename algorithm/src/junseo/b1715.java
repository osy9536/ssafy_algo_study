package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}
		long res = 0;
		while(queue.size()>=2) {
			int a = queue.poll();
			int b = queue.poll();
			queue.add(a+b);
			res += (a+b);
		}
		System.out.println(res);

	}
}

