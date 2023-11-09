package algorithm.src.junseo;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N, M;
		M= Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		boolean[] A;
		A = new boolean[N + 1];

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (!A[i]) {
				for (int j = i+i; j <= N; j+=i) {
					if (!A[j]) {
						A[j] = true;
					}
				}
			}
		}
        StringBuilder sb = new StringBuilder();
		if(M == 1) M++;
		for (int i = M; i <= N; i++) {
			if(!A[i])sb.append(i).append('\n');
		}
        System.out.print(sb);
	}
}


