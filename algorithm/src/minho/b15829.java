package ssafy_algo_study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b15829{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String S = br.readLine();
		long result = 0;
		long pow = 1;
		for(int i = 0; i < L; i++) {
			result += ((S.charAt(i) - 96) * pow);
			//pow는 31을 매번 곱해준다. 곱해줄때마다 1234567891을 나눠주면 long을 넘지 않을 것이다.
			pow = (pow * 31) % 1234567891;
		}
		System.out.println(result % 1234567891);
	}

}