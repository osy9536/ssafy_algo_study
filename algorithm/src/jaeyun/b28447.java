package algorithm.src.jaeyun;

import java.util.Arrays;
import java.util.Scanner;

public class b28447 { /* HiCon_D 2023.08.13 */
	static int N, K;
	static int[] input;
	static int[] result;
	static int[][] mat;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		mat = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		input = new int[N];
		result = new int[K];
		for (int i=0; i<N; i++) input[i] = i;
		ans = Integer.MIN_VALUE;
		combination(0, 0);
		System.out.println(ans);
	}
	public static void combination(int start, int cnt) {
		if (cnt == K) {
//			System.out.println(Arrays.toString(result));
			int calcMaratangComb = 0;
			for (int i=0; i<K; i++) {
				for (int j=i+1; j<K; j++) {
					calcMaratangComb += mat[result[i]][result[j]];
//					System.out.println(i+", "+j+" | "+result[i]+", "+result[j]);
				}
			}
			if (calcMaratangComb > ans) ans = calcMaratangComb;
			return;
		}
		for (int i=start; i<N; i++) {
			result[cnt] = input[i];
			combination(i+1, cnt+1);
		}
	}
}
