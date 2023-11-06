package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 3020
 * 개똥벌레
 * 골드 5
 * https://www.acmicpc.net/problem/3020
 */
public class b3020 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //obstacle width
		int h = Integer.parseInt(st.nextToken()); //obstacle height
		
		int[] down = new int[h + 1];
		int[] up = new int[h + 1];
		
		for(int i = 0; i < n / 2; i++) {
			down[Integer.parseInt(br.readLine())] += 1;
			up[Integer.parseInt(br.readLine())] += 1;
		}
		
		for(int i = h; i > 0; i--) {
			down[i - 1] += down[i];
			up[i - 1] += up[i];
		}
		
		int min = Integer.MAX_VALUE;
		int count = 0;
		for(int i =1 ; i <= h; i++) {
			int b = down[i] + up[h - i + 1];
			
			if(min == b) {
				count += 1;
			} else if(b < min) {
				count = 1;
				min = b;
			}
		}
		
		System.out.println(min + " " + count);
		
	}
}
