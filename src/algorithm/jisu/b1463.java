package algorithm.jisu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int max = n - 1;
		
		Queue<int[]> que = new LinkedList<int[]>();
		int[] nc = {n, 0};
		if (n!=1) que.add(nc);
		
		while (que.size()>0) {
			int[] numcnt = que.poll();
			int now =numcnt[0];
			int cnt =numcnt[1]+1;
			
			if (cnt >= max) continue;
			
			int n3 = now/3;
			int n2 = now/2;
			int n1 = now-1;
			
			if (now%3==0) {
				if (n3 == 1 && cnt < max) max = cnt; 
				else {
					int[] gogo = {n3, cnt};
					que.add(gogo);
				}
			}
			if (now%2==0) {
				if (n2 == 1 && cnt < max) max = cnt;
				else {
					int[] gogo = {n2, cnt};
					que.add(gogo);
				}
			} 
			if (n1==1 && cnt < max) max = cnt;
			else {
				int[] gogo = {n1, cnt};
				que.add(gogo);
			}
			
		}
		
		System.out.println(max);

	}
}
