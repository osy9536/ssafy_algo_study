package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b2075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		}) ;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < n; i++) {
			int num = que.poll();
			if (i == n-1) {
				System.out.println(num);
				break;
			}
		}
		
	}
}
