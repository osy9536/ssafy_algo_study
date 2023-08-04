import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1016 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		//제곱ㄴㄴ수 구하기
		boolean check[] = new boolean[(int) (m-n+1)];
		for(long i = 2; i*i <= m; i++) {
			long square = i*i; 
			long start = n / square;
			if(n % square != 0) start++;
			for(long j = start; j * square <= m; j++) {
				check[(int)((j * square) - n)] = true;
			}
		}
		int cnt = 0;
		for(int i = 0; i <= (m-n); i++) {
			if(!check[i]) cnt++;
		}
		System.out.println(cnt);
	}	
}
