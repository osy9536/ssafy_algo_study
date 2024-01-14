package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int [] A;
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		while(K >= A[0]) {
			N--;
			ans += K/A[N];
			K %= A[N];
			
		}
		System.out.println(ans);

	}

}

