package algorithm.jaeyun;

import java.util.Scanner;

public class b28293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		// log(a**b) = b*log(a)
		System.out.println(1+(int)(b * Math.log10(a)));
	}
}
