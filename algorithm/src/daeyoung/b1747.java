package algorithm.src.daeyoung;

import java.io.*;

/**
 * 백준 1747
 * 소수&팰린드롬
 * 실버1
 * https://www.acmicpc.net/problem/1747
 */
public class b1747 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = n; i < 10000000; i++) {
			if(isPrime(i)) {
				if(isPalindrome(i)) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	//시간 복잡도 O(√N) 
	public static boolean isPrime(int n) {
		if(n < 2)
			return false;
		
		if(n == 2)
			return true;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static boolean isPalindrome(int n) {
		char[] num = (n + "").toCharArray();
		
		int start = 0;
		int end = num.length - 1;
//		System.out.println("<<<" + n + ">>>");
		while(start <= end) {
			
//			System.out.println(num[start] + ", " + num[end]);
			if(num[start++] == num[end--])
				continue;
			else
				return false;
		}
		
		return true;
	}
	
}
