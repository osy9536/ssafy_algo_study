package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int tscore = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		if (n != 0) st = new StringTokenizer(br.readLine());
		
		Integer[] arr = new Integer[n+1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		arr[n] = tscore;
		
		Arrays.sort(arr, Comparator.reverseOrder());
		
		int answer = -1;
		
		for (int i = 0; i < p; i++) {
			if (arr[i] == tscore) {
				if (n == p && i == p-1 && arr[i] == arr[i+1]) break;
				answer = i+1;
				break;
			}
		}
		
		for (int i = arr.length-1; i >= 0; i--) {
			if (arr[i] == tscore) {
				if (i > p-1) answer = -1;
				break;
			}
		}
		
		System.out.println(answer);
	}
}
