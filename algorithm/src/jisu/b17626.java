package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b17626 { 
	static int result = Integer.MAX_VALUE;
	
	static void pick(int num, int cnt, int front) {
		if (num == 0) {
			if (result > cnt) result = cnt;
			return;
		}
		if (cnt >= 4) return;
		
		for (int i = Math.min((int) Math.sqrt(num), front); i > 0; i--) { // 전에 거보다 큰 수 (중복된 경우) 나오지 않게 
			pick(num - i * i, cnt + 1, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		pick(n, 0, n);
		
		System.out.println(result);
	}
}
