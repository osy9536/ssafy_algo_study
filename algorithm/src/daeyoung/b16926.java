package algorithm.src.daeyoung;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 16926
 * 배열 돌리기1
 * 실버1
 * https://www.acmicpc.net/problem/16926
 */
public class b16926 {
	static int[][] a;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		a = new int[n + 1][m + 1];
		
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < m + 1; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < r; i++)
			rotation(n, m);
		print();
	}
	
	public static void rotation(int n, int m) {
		for(int cnt = 0; cnt < Math.min(m, n) / 2; cnt++) {
			int row = 1 + cnt;
			int col = 1 + cnt;
			
			int temp = a[row][col];
			//위
			for(int j = col; j < m - cnt; j++) {
				a[row][j] = a[row][j + 1];
			}
			
			//오른
			for(int i = row; i < n - cnt; i++) {
				a[i][m - cnt] = a[i + 1][m - cnt];
			}
			
			//아래
			for(int j = m - cnt; j > col; j--) {
				a[n - cnt][j] = a[n - cnt][j - 1];
			}
			
			//왼
			for(int i = n - cnt; i > row; i--) {
				if(i == row + 1) {
					a[i][col] = temp;
					break;
				}
				
				a[i][col] = a[i - 1][col];
			}
		}
		
		
	}
	
	public static void print() {
		for(int i = 1; i < a.length; i++) {
			for(int j = 1; j < a[i].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

}
