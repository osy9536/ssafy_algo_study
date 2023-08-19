package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1028 {
	public static int[][] san;
	public static int r;
	public static int c;
	public static int maxi;
	public static int result;
	
	public static int selectRange(int y, int x) {
		return Math.min((r-1-y)/2, Math.min(x, c-1-x));
	}
	
	public static boolean canI(int y, int x, int r) {
		int up = y;
		int bo = y+2*r;
		int left = x;
		int right = x;
		if (san[bo][x] + san[y+r][x-r] + san[y+r][x+r] != 3) return false;
		
		for (int i = 0; i < r-1; i++) {
			up++;
			bo--;
			left--;
			right++;
//			System.out.printf("canI %d %d %d %d\n", up,bo,left,right);
			if (san[up][left] + san[up][right] + san[bo][left] + san[bo][right] != 4) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		r = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);
		if (r<c) maxi = (r+1) / 2;
		else maxi = (c+1) / 2;
		
		
		san = new int[r][c];
		for (int i = 0; i < r; i++) {
			s = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				san[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (san[i][j] == 1) {
					int sr = selectRange(i, j);
					
//					System.out.printf("%d %d %d %d\n",i,j,sr,result);
					for (int k = sr; k >= result; k--) { // result보다 큰 값만 체킹하기! 여기서 시간 많이 줄일 수 있다
						if (canI(i, j, k)) {
							result = k+1; 
							break;
						}
					}
				}
				if (result == maxi) break;
			}
			if (result == maxi) break;
		}
		
		System.out.println(result);
	}
}
