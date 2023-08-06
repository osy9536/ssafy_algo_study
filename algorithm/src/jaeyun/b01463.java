package algorithm.src.jaeyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b01463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		int ans = 0;
		q.add(X);
		while (true) {
			int qsize = q.size();
			for (int i=0; i<qsize; i++) {
				int n = q.poll();
				if (n == 1) {
					System.out.println(ans);
					sc.close();
					return;
				}
				if (n % 3 == 0) q.add(n / 3);
				if (n % 2 == 0) q.add(n / 2);
				q.add(n - 1);
			}
			ans++;
		}
	}
}
