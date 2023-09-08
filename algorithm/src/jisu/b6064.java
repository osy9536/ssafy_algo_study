package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6064 { 
	static int n;
	static int m;

	public static int gong(int mini, int maxi) {
		if (maxi % mini == 0) return maxi;
		for (int i = (int)Math.sqrt(mini); i > 0; i--) {
			if (mini % i == 0 && maxi % i == 0) return mini * maxi / i;
		}
		return mini * maxi;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result = -1;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			result = -1;
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if (m > n) {
				int temp = m;
				m = n;
				n = temp;
				temp = y;
				y = x;
				x = temp;
			}
			
			int now = x;
			int g = gong(m, n);
			for (int i = 0; i * n <= g; i++) {
				int nPer = (now + (i * n) - 1) % m + 1; // x == m일 때 0이 아닌 1이 됨에 주의
				if (nPer == y) {
					result = now + i*n;
					break;
				}
				
			}
			System.out.println(result);
		}
		
	}
}
