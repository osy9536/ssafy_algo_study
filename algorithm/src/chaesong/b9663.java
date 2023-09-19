import java.util.*;
import java.io.*;

public class Nqueen {
	static int N, cnt;
	static int place[]; //하나의 row에는 하나의 퀸만 올 수 있음
	static boolean visit[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		place = new int[N];
		visit = new boolean[N];
		cnt = 0;
		queen(0);
		System.out.println(cnt);
	}
	static void queen(int row) {
		if(row >= N) {
			cnt++;
			return;
		}
		for(int col = 0; col < N; col++){
			if(!visit[col] && check(row, col)){ //방문한 적 없는 col라면
				visit[col] = true;
				place[row] = col;
				queen(row+1);
				visit[col] = false;
			}
		}
	}
	static boolean check(int row, int col) {
		for(int i = 0; i < row; i++) { //지금까지 진행된 열 중에서
			if(Math.abs(i-row) == Math.abs(place[i]-col)) return false;
		}
		return true;
	}
}
