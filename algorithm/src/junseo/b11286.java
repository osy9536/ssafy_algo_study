package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_BJ_11286_절대값힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
//		Comparator<Integer> comparator = new Comparator<Integer>() {
//			
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				if(Math.abs(o1) ==  Math.abs(o2)) {
//					return o1 - o2;
//				}
//				return Math.abs(o1) - Math.abs(o2);
//			}
//		};
//  PriorityQueue<Integer> pqueue= new PriorityQueue<>(comparator);
		PriorityQueue<Integer> pqueue= new PriorityQueue<>((o1,o2)
				-> Math.abs(o1) ==  Math.abs(o2) ?  o1 - o2 : Math.abs(o1) - Math.abs(o2) );
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(pqueue.isEmpty()) sb.append(0).append("\n");
				else{
					sb.append(pqueue.poll()).append("\n");
				}
			}
			else {
				pqueue.offer(a);
			}
		}
		System.out.println(sb);
	}

}

