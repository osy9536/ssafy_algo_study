package algorithm.chaesong;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			myQueue.add(i);
		}
		while(myQueue.size() > 1) {
			myQueue.poll();
			int back = myQueue.poll();
			myQueue.add(back);
		}
		System.out.println(myQueue.poll());
	}
}
