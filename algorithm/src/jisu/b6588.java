package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b6588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] sosu = new int[1000001];
		sosu[2] = 2;
		for (int i = 3; i < sosu.length; i++) {
			if (i % 2 == 1) sosu[i] = i;
		}
		
		for (int i = 3; i < Math.sqrt(sosu.length) + 1; i += 2) {
			if (sosu[i] == 0) continue;
			for (int j = i * i; j < sosu.length; j += 2 * i) {
				sosu[j] = 0;
			}
		}
		
//		System.out.print(Arrays.toString(sosu));
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) break;
			
			boolean printed = false;
			for (int i = 3; i < n; i += 2) {
				if (sosu[i] != 0 && sosu[n-i] != 0) {
					bw.write(n + " = " + i + " + " + (n-i) + "\n");
					printed = true;
					break;
				}
			}
			if (!printed) bw.write("Goldbach's conjecture is wrong.\n");
		}
		
		bw.flush();
		bw.close();
	}
}
