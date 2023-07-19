package algorithm.src.daeyoung;

import java.io.*;

/**
 * 백준 2447
 * 별 찍기 - 10
 * 골드 5
 * https://www.acmicpc.net/problem/2447
 */
public class b2447 {
	
	static char[][] stars;
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// 3의 거듭제곱
			int n = Integer.parseInt(br.readLine());
			
			stars = new char[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					makeStar(i, j, n);
			}
			
			printStar(stars);
	}
	
	public static void makeStar(int row, int col, int n) {
		
		if((row/n)%3 == 1 && (col/n) % 3 == 1)
			stars[row][col] = ' ';
		else {
			if(n / 3 == 0)
				stars[row][col] = '*';
			else
				makeStar(row, col, n/3);
		}
	}
	
	public static void printStar(char[][] stars) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < stars.length; i++) {
			for(int j = 0; j < stars.length; j++)
				bw.write(stars[i][j]);
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
