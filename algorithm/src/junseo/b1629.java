package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 자연수 A를 B번 곱한 수를 알고 싶다. 
 * 단 구하려는 수가 매우 커질 수 있기 떄문에 이를 C로 나눈 나머지를 구하기
 * A^B % C 
 * A^B = (A^(B/2) * A^(B/2))
 * A^B % C = (A^(B/2)%C * A^(B/2)*C)
 * 2^4 % 3 = 2^2%3 * 2^2%3
 * 16%3 = 4%3 * 4%3 = 1 
 */
public class Main_BJ_1629_곱셈 {
	static long A,B,C;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(modular(A,B));
		
	}
	private static long modular(long a,long b) { // a의 b승 
		
		if(b == 1) {
			return a%C;
		}
		
		long temp = modular(a,b/2);
		if(b %2 == 1) {
			return (((temp*temp)%C)*(a%C))%C;
		}
		return ((temp*temp)%C);
		
	}

}


