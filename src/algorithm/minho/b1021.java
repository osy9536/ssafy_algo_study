package algorithm.minho;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class b1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		Deque<Integer> dq = new LinkedList<>(); 
		for(int i = 1 ; i<=a ; i++) {
			dq.offer(i);
		}// 1 ~ a 까지 input
		int cnt =0;
		while(b-->0) {
			int n = sc.nextInt(); //처음 뺄 숫자위치
			int index=0;
			for(int i : dq) { //index확인
				if(i==n)
					break;
				else
					index++;
			}
			if(index<(dq.size()-index))
				while(index>0) {
					dq.offerLast(dq.removeFirst());
					index--;
					cnt++;
				}
			else {
				index=(dq.size()-index);
				while(index>0) {
					dq.offerFirst(dq.removeLast());
					index--;
					cnt++;
				}
			}
			int x = dq.pollFirst();
		}
		System.out.println(cnt);
	}
}
