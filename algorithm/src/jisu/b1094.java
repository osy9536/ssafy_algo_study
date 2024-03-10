package algorithm.src.jisu;

import java.io.*;

public class b1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int stick = 64;
		int cnt = 0;
		
		while (n > 0) {
			if (stick > n) stick /= 2;
			else {
				n -= stick;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
