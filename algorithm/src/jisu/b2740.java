package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class b2740 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] mat = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
//		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] tma = new int[m][k];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				tma[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[][] result = new int[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				for (int l = 0; l < m; l++) {
					result[i][j] += mat[i][l] * tma[l][j];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				System.out.printf("%d ", result[i][j]);
			}
			System.out.println();
		}
	}
}
