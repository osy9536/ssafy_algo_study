package algorithm.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int a = Integer.parseInt(br.readLine());
		for(int i =0;i<a;i++) {
			q.add(i+1);
		}// 큐에 다 집어 넣기
		while(q.size()>1) {
			q.poll();
			int b=q.peek();
			q.poll();
			q.add(b);
		}
		System.out.println(q.peek());
	}
}
