package algorithm.src.ohseyoung;

import java.io.IOException;

// 달팽이 리스트
// silver 2
public class b17827 {
	public static StringBuilder sb = new StringBuilder();
	public static java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String s = br.readLine().trim();
		String str1[] = s.split(" ");	
		int n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);
		int v = Integer.parseInt(str1[2]);
		
		s = br.readLine().trim();
		str1 = s.split(" ");
		
		for(int i = 0; i < m; i++) {
			int q = Integer.parseInt(br.readLine().trim());
			sb.append(str1[solved(n,q,v)]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int solved(int n, int q, int v) {
		int num = 0;
		if(q < n) {
			return q;
		}
		if(v == n) {
			return n-1;
		}
		num = (q-n)%(n-v+1) + v-1;
		return num;
	}
}
