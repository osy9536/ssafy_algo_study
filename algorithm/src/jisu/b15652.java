package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b15652 {
	static int n, m, result;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	
	public static void dfs(int now, int cnt) {
		if (cnt >= m) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = now; i <= n; i++) {
			arr[cnt] = i;
			dfs(i, cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		arr = new int[m];
		
		dfs(1, 0);
		
		System.out.println(sb.toString());
	}
}
