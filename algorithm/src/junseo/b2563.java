package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N  = Integer.parseInt(br.readLine());
		int [][] mx = new int[101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = x; j <x+10; j++) { 
				for (int j2 = y; j2 < y+10; j2++) { 
					mx[j][j2] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i <=100; i++) {
			for (int j = 0; j <=100; j++) {
				if(mx[i][j] == 1) cnt++;
			}
		}
		System.out.println(cnt);
	}
}

