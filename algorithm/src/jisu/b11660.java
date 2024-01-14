package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b11660 {
	static int n, m;
	static int[][] summ;
	
	public static int check(int w, int v) {
		if (w < 0 || v < 0) return 0;
		else return summ[w][v];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		int[][] garo = new int[n][n];
		summ = new int[n][n];
		
		int a = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = 0;
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				a += arr[i][j];
				garo[i][j] = a;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k <= i; k++) {
					summ[i][j] += garo[k][j];
				}
			}
		}
		
		int[] nums = new int[4];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				nums[j] = Integer.parseInt(st.nextToken()) - 1;
			}
			
			int one = summ[nums[2]][nums[3]];
			int two = check(nums[2], nums[1]-1);
			int thr = check(nums[0]-1, nums[3]);
			int fou = check(nums[0]-1, nums[1]-1);
			
			bw.write((one - two - thr + fou) + "\n");

		}
		
		bw.flush();
		bw.close();
		
	}
}
