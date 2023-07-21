package algorithm.src.jaeyun;

import java.util.Scanner;

public class b17103 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] isprime = new boolean[1000001];
		for (int i=2; i<=1000000; i++) {
			isprime[i] = true;
		}
		for (int i=2; i<=1000000; i++) {
			for (int j=i+i; j<=1000000; j+=i) {
				isprime[j] = false;
			}
		}
//		System.out.println(primes.size()+" prime numbers");
		
		for (int tc=0; tc<T; tc++) {
			int n = sc.nextInt();
			if (n == 4) {
				System.out.println(1);
				continue;
			}
			int ans = 0;
			for (int i=2; i<=n/2; i++) {
				if (isprime[i] && isprime[n-i]) ans++;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
