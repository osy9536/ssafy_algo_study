package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2669 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result = 0;
		int[][] square = new int[4][4];
		boolean[][] hap = new boolean[100][100];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int y = square[i][1]; y < square[i][3]; y++) {
				for (int x = square[i][0]; x < square[i][2]; x++) {
					hap[y][x] = true;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (hap[i][j]) result++;
			}
		}
		
		System.out.println(result);
	}
}
