package algorithm.src.jaeyun;

import java.util.Arrays;
import java.util.Scanner;

public class b05212 {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] map = new char[R][C];
		char[] tmp = null;
		for (int i=0; i<R; i++) {
			tmp = sc.next().toCharArray();
			for (int j=0; j<C; j++) {
				map[i][j] = tmp[j];
			}
		}
//		System.out.println(Arrays.deepToString(map));
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == '.') continue;
				int seaCount = 0;
				for (int d=0; d<4; d++) {
					int nr = i + dx[d];
					int nc = j + dy[d];
					if (nr<0 || nc<0 || nr>R-1 || nc>C-1 || map[nr][nc] == '.') {
						seaCount += 1;
					}
				}
				if (seaCount >= 3) map[i][j] = '#';
			}
		}
//		System.out.println(Arrays.deepToString(map));
		
		int nCstart = 0; int nCend = C; int nRstart = 0; int nRend = R;
		// reduce column
		for (int j=0; j<C; j++) {
			boolean reduce = true;
			for (int i=0; i<R; i++) {
				if (map[i][j] == 'X') reduce = false;
			}
			if (reduce) nCstart += 1;
			else break;
		}
		for (int j=C-1; j>=0; j--) {
			boolean reduce = true;
			for (int i=0; i<R; i++) {
				if (map[i][j] == 'X') reduce = false;
			}
			if (reduce) nCend -= 1;
			else break;
		}
		// reduce row
		for (int i=0; i<R; i++) {
			boolean reduce = true;
			for (int j=0; j<C; j++) {
				if (map[i][j] == 'X') reduce = false;
			}
			if (reduce) nRstart += 1;
			else break;
		}
		for (int i=R-1; i>=0; i--) {
			boolean reduce = true;
			for (int j=0; j<C; j++) {
				if (map[i][j] == 'X') reduce = false;
			}
			if (reduce) nRend -= 1;
			else break;
		}
//		System.out.printf("R start: %d\tR end: %d\tC start: %d\tC end: %d\n", nRstart, nRend, nCstart, nCend);
		int nR = nRend - nRstart; int nC = nCend - nCstart;
		char[][] newMap = new char[nR][nC];
		for (int i=0; i<nR; i++) {
			for (int j=0; j<nC; j++) {
				if (map[nRstart + i][nCstart + j] == '#') map[nRstart + i][nCstart + j] = '.';
			}
			newMap[i] = Arrays.copyOfRange(map[nRstart + i], nCstart, nCend);
		}
//		System.out.println(Arrays.deepToString(newMap));
		for (int i=0; i<nR; i++) {
			for (int j=0; j<nC; j++) {
				System.out.print(newMap[i][j]);
			}
			System.out.println();
		}
	}
}
