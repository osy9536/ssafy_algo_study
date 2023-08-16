package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2630 {
	public static boolean allSame(int[][] paper, int[] wv, int n) {
		int color = paper[wv[0]][wv[1]];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (paper[wv[0]+i][wv[1]+j] != color) return false;
			}
		}
		return true;
	}
	
	public static int[] divide(int[][] paper, int[] wv, int n) {
		int[] whiteBlue = new int[2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				/*
				 * allSame이 트루면 whiteBlue 색깔 따져서 +1
				 * false면 divide 더 돌리고 그 안에서 값 가져와야함
				 */
				
//				System.out.println("hello " + (wv[0]+i*n) + " " + (wv[1]+j*n) + " " + n + "~~~~~");
				if (!allSame(paper, new int[] {wv[0]+i*n, wv[1]+j*n}, n)) {
//					System.out.println("땡~~");
					int[] a = divide(paper, new int[] {wv[0]+i*n, wv[1]+j*n}, n/2);
//					System.out.println(a[0]+" "+a[1]);
					whiteBlue[0] += a[0];
					whiteBlue[1] += a[1];
				}
				else {
//					System.out.println((wv[0]+i*n) + " " + (wv[1]+j*n) + " " + n + " true");
					int color = paper[wv[0]+i*n][wv[1]+j*n];
					whiteBlue[color] += 1;
				}
			}
		}
		return whiteBlue;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int oriN = n;
		
		int[][] paper = new int[n][n];
		
		for (int i = 0; i < paper.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < paper[i].length; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] result = new int[2];
		int checkedPaper = 0;
		
		if (allSame(paper, new int[] {0,0}, n)) {
			result[paper[0][0]]++;
		} else {
			result = divide(paper, new int[] {0,0}, n/2);
		}
		
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
