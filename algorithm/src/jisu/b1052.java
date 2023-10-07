package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1052 {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int plus = 0;
		
		int result = -1;
		
		while (true) {
			int s = n + plus;
			int cnt = 0;

			while (s > 0) {
				if (s % 2 != 0) cnt++;
				s /= 2;
			}
			
			if (cnt <= m) {
				result = plus;
				break;
			}
			else plus++;
		}
		
		
		System.out.println(result);
		
	}
}
