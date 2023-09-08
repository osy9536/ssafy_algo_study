package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n+1];
		int[] nujuk = new int[n+1];
		int summ = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			summ += num[i];
			nujuk[i] = summ;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bw.write(nujuk[e] - nujuk[s-1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
