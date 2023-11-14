package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long sqrt = (long) Math.sqrt(n);
		long res = n;
		
		for (long i = 2; i <= sqrt; i++) {
			if(n % i == 0) res = res - res/i; // res*i/(i-1)
			
			while(n%i == 0) {
				n /= i;
			}
		
		}
		if(n>1) res = res-res/n;
		System.out.println(res);		
	}
	
}

