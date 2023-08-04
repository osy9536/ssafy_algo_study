package algorithm.src.jisu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b15650 {
	public static void pick(int start, int end, int m, List<Integer> now) {
		for (int i = start; i <= end; i++) {
			now.add(i);
			
			if (now.size() == m) {
				printNow(now);
			} else {
				pick(i+1, end, m, now);
			}
			
			now.remove(now.size()-1);
		}
	}
	
	public static void printNow(List<Integer> now) {
		
		for (int i = 0; i < now.size(); i++) {
			System.out.print(now.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		pick(1, n, m, new ArrayList<Integer>());
		
	}
}
