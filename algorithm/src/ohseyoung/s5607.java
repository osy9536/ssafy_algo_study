package algorithm.src.ohseyoung;

import java.util.Scanner;

// [Professional] 조합
// d3
public class s5607 {
	static long N,R;
	static long p = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			R = sc.nextInt();
			
			long a = 1;
			long b = 1;
			
			long t = Math.min(R, N-R);
			
			for(int i=0; i<t; i++) {
				a = a*(N-i)%p;
				b = b*(t-i)%p;
			}			
			long ans = (a%p*div(b,p-2)%p)%p;
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static long div(long a, long b) {
		if(b==1)
			return a;
		long tmp = div(a, b/2);
		if(b%2 == 1)
			return tmp*tmp%p*a%p;
		else
			return tmp*tmp%p;
	}
}
