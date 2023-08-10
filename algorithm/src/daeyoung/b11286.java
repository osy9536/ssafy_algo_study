package algorithm.src.daeyoung;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 백준 11286
 * 절댓값 힘
 * 실버1
 * https://www.acmicpc.net/problem/11286
 */
public class b11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				if (Math.abs(i1) == Math.abs(i2))
					return i1 - i2;
				return Math.abs(i1) - Math.abs(i2);
			}
		});
		
		for(int i = 0; i < n; i++) {
			int cur = Integer.parseInt(br.readLine());
			
			if(cur != 0)
				q.add(cur);
			else {
				Integer temp = q.poll();
				if(temp == null)
					System.out.println(0);
				else
					System.out.println(temp);
			}
				
			
			
		}
	}
}
