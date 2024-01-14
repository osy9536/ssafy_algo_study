package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		int start = 0;
		int end = A.length-1;
		int sum = A[start] + A[end];
		int res = 0;
		while(end>start) {
			if(sum == M) {
				res++;
				sum -= A[end];
				end--;
				sum += A[end];
			}
			else if(sum<M) {
				sum -= A[start];
				start++;
				sum+= A[start];
			}
			else {
				sum -= A[end];
				end--;
				sum += A[end];
			}
		}
		System.out.println(res);
	}
}


