package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1246 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[m];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int price = 0;
		int bene = 0;
		for (int i = 1; i <= arr.length; i++) {
			int p = arr[m-i];
			int b = p * Math.min(i, n);
			if (bene <= b) {
				bene = b;
				price = p;
			}
		}
		
		System.out.println(price + " " + bene);
		
	}
}
