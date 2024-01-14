import java.util.*;
import java.io.*;

public class b17136 {
	static int arr[][];
	static int paper[] = {0, 5, 5, 5, 5, 5};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[10][10];
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		
		dfs(0, 0, 0);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	//색종이 붙일 수 있음?
	static boolean check(int n, int stx, int sty) {
		for(int i = stx; i < stx+n; i++) {
			for(int j = sty; j < sty+n; j++) {
				if(i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				if(arr[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	//nxn짜리 색종이 상태 바꾸기
	//what = 1이면 색종이 떼는거고
	//what = 0이면 색종이 붙이는 거
	static void putPaper(int n, int stx, int sty, int what) {
		for(int x = stx; x < stx+n; x++) {
			for(int y = sty; y < sty+n; y++) {
				arr[x][y] = what;
			}
		}
	}
	
	//dfs
	static void dfs(int stx, int sty, int cnt) {
		// 가장 마지막에 도착하면
		if(stx >= 9 && sty > 9) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		if(sty > 9) {
			dfs(stx+1, 0, cnt);
			return;
		}
		
		
		if(cnt >= answer) {
			return;
		}
		
		
		if(arr[stx][sty] == 1) {
			for(int i = 5; i >= 1; i--) {
				if(paper[i] > 0 && check(i, stx, sty)) {
					putPaper(i, stx, sty, 0);
					paper[i]--;
					dfs(stx, sty+1, cnt+1);
					putPaper(i, stx, sty, 1);
					paper[i]++;
				}
			}
		}else {
			// 아니라면 옆으로 이동
			dfs(stx, sty+1, cnt);
		}
	}
}
