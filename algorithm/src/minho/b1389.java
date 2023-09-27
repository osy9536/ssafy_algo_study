package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1389 {
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (i != j && map[k][j] != 0 && map[i][k] != 0) {
						if(map[i][j]==0) {
							map[i][j] = map[i][k] + map[k][j];
						}else {
							map[i][j] = (map[i][j] > map[i][k] + map[k][j]) ? (map[i][k] + map[k][j]) : map[i][j];
						}
					}
				}
			}
		}
		int minVal = Integer.MAX_VALUE, minnum = 0;
		for (int i = 1; i < N + 1; i++) {
			int sum = 0;
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] != 0)
					sum += map[i][j];
			}
			if (minVal > sum) {
				minVal = sum;
				minnum = i;
			}
		}
		System.out.println(minnum);
	}
}
/*
 * 1 2 2 0 0 0 0
 */