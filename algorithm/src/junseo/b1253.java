package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long [] A;
	static int N;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		A = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);
		res = 0;
		for (int i = 0; i < N; i++) {
			twoP(i);
		}
		System.out.println(res);
	}
	private static void twoP(int i) {
		int st = 0;
		int end = N-1;
		long sum;
		long goal = A[i];
		while(end > st) {
			sum = A[st] + A[end];
			if(sum == goal) {
				if(st != i && end != i) {
					res++;
					break;
				}
				else if(st==i) st++;
				else if(end==i)end--;
			}
			else if(sum<goal) {
				st++;
			}
			else end--;
		}
		
	}

}


