package algorithm.src.jisu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b5525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		
		int cnt = 0;
		int result = 0;
		for (int i = 1; i < m-1; i++) {
			if (s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
				cnt++;
				
				if (cnt == n) {
					cnt--;
					result++;
				}
				
				i++;
				
			} else {
				cnt = 0;
			}
		}
		
		System.out.println(result);
	}
}
