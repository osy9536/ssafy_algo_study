package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b25186 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long sum = 0;
		for (int i = 0; i < N-1; i++) {
			sum += arr[i];
		}
		if(N == 1) {
			if(arr[0]>1)System.out.println("Unhappy");
			else System.out.println("Happy");
		}
		else if(sum<arr[N-1]) System.out.println("Unhappy");
		else System.out.println("Happy");
	}
}


