package algorithm.src.daeyoung;

import java.io.*;


/**
 * 백준 2023
 * 신기한 소수
 * 골드5
 * https://www.acmicpc.net/problem/2023
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());	
		
		find(0, 0, n);
		
	}
	
	public static void find(long num, int cnt, int depth) {
		if(cnt == depth && isPrime(num)) {
			System.out.println(num);
			return;
		}
		
		num *= 10;
		
		for(long i = 0; i < 10; i++) {
			long temp = num;
			temp += i;
			if(!isPrime(temp))
				continue;
			find(temp, cnt + 1, depth);
		}
			
	}
	
	public static boolean isPrime(long num) {
		if(num < 2)
			return false;
		
		if(num == 2)
			return true;
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		
		return true;
	}

}
