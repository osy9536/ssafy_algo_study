package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//같은 행에는 퀸을 놓지 않는 버전 (열번호 비교, 대각선 체크) 
//대각선 체크  => 행-행 = |열-열|
//해당 행에 열마다 퀸을 세워보고 기준에 맞는지 체크 
public class Main_BJ_9663_NQueen {
	static int N;
	static int[] col;
	static int ans=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N];
		sol(0);
		System.out.println(ans);
		
	}

	private static void sol(int row) { // row : 행
		
		if (row == N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			col[row] = i;
			if (isVailed(row)) {
				sol(row + 1);
			}
		}

	}
	
	private static boolean isVailed(int row) {
	
		for(int i = 0 ; i<row;i++) {
			if(col[row] == col[i] || row - i == Math.abs(col[row] - col[i])) {
				return false;
			}
		}
		return true;
	}
}


