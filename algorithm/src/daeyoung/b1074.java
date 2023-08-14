package algorithm.src.daeyoung;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1074
 * Z
 * 실버1
 * https://www.acmicpc.net/problem/1074
 */
public class b1074 {
	static int r;
	static int c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int num = (int)Math.pow(2, n);
		zShape(num, 0, 0, 0);
	}
	
	public static void zShape(int n, int start, int row, int col) {
		if(n == 2) {
			if(row <= r && r <= row + n /2 &&
					col <= c && c <= col + n /2) {
				
				if(r - row == 0) {
					if(c - col == 0)
						System.out.println(start);
					else
						System.out.println(start + 1);
				} else {
					if(c - col == 0)
						System.out.println(start + 2);
					else
						System.out.println(start + 3);
				}
				
			}
			return;
		}
		
		if(row <= r && r <= row + n /2 &&
				col <= c && c <= col + n /2)
			zShape(n/2, start, row, col);
		
		if(row <= r && r <= row + n /2 &&
				col + n / 2 <= c && c <= col + n)
		zShape(n/2, start + (n/2)*(n/2), row, col + n / 2 );
		
		if(row + n /2 <= r && r <= row + n &&
				col <= c && c <= col + n /2)
		zShape(n/2, start +  (n/2)*(n/2) * 2, row + n /2 , col);
		
		if(row + n /2 <= r && r <= row + n &&
				col + n /2 <= c && c <= col + n)
		zShape(n/2, start +  (n/2)*(n/2) * 3, row + n /2, col + n /2);
	}
}
