package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17103 {
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static boolean [] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		prime = new boolean[1_000_001];
		makePrime();
		for (int i = 0; i <N ; i++) {
			int a =  Integer.parseInt(br.readLine());
			sol(a);	
		}
		System.out.println(sb);
	}

	private static void sol(int n) {
		int count = 0;

		for (int i = 2; i <= n / 2; i++) {
			if (!prime[i] && !prime[n - i]) {
				count++;
			}
		}
		sb.append(count).append("\n");
	}

	private static void makePrime() {
		for (int i = 2; i * i <= 1000000; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= 1000000; j += i) {
					if (prime[j])
						continue;
					prime[j] = true;
				}
			}
		}
	}

}


