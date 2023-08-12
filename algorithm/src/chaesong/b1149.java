import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class b1149 {
	//color은 색깔
	static int N;
	static int dp[][];
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ans = new ArrayList<>();
		N = sc.nextInt();
		dp = new int[N+1][3];
		arr = new int[N+1][3];
		//0은 빨강, 1은 초록, 2는 파랑
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		if(N >= 2) {
			for(int i = 0; i < 3; i++) {
				dp[1][i] = arr[1][i];
				for(int j = 2; j <= N; j++) {
					min(j);
				}
			}
			ans.add(dp[N][0]);
			ans.add(dp[N][1]);
			ans.add(dp[N][2]);
		}
		Collections.sort(ans);
		System.out.println(ans.get(0));
	}
	static void min(int depth) {
		dp[depth][0] = Math.min(dp[depth-1][1], dp[depth-1][2]) + arr[depth][0];
		dp[depth][1] = Math.min(dp[depth-1][0], dp[depth-1][2]) + arr[depth][1];
		dp[depth][2] = Math.min(dp[depth-1][0], dp[depth-1][1]) + arr[depth][2];
	}
}
