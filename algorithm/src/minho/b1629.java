package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1629 곱셈
public class b1629{
	static long A,B,C;
	public static long re(long A,long B) {
		if(B==0) return 1;
		else if (B==1) return A;
		if(B%2>0) return re(A,B-1)*A;
		long half = re(A,B/2);
		half %=C;
		return (half *half) % C;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(re(A,B)%C);
	}
}

