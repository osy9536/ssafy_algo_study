package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] A;
	static int [] temp;
	static long res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N;
	
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		temp = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		res = 0;
		mergeSort(0,N-1);
		System.out.println(res);
		
	}

	private static void mergeSort(int S, int E) {
		if(E-S < 1) return;
		
		int mid = (S+E)/2;
		mergeSort(S,mid);
		mergeSort(mid+1,E);
		
		for (int i = S; i <= E; i++) {
			temp[i] = A[i];
		}
		
		int k = S;
		int idx1 = S;
		int idx2 = mid+1;
		
		while(idx1<=mid && idx2<=E) {
			if(temp[idx1]<=temp[idx2]) {
				A[k] = temp[idx1];
				idx1++;
				k++;
			}
			else {
				A[k] = temp[idx2];
				idx2++;
				k++;
				res += (mid-idx1+1);
			}
		}
		while(idx1<=mid) {
			A[k] = temp[idx1];
			idx1++;
			k++;
		}
		while(idx2<=E) {
			A[k] = temp[idx2];
			idx2++;
			k++;
		}

	}
}



