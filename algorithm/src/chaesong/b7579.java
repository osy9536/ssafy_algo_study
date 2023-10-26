import java.util.*;
import java.io.*;

public class b7579 {
	static int n, m;
	static int answer = Integer.MAX_VALUE;
	static int[] mem, c;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n+1];
		
		mem = new int[n+1]; //각 앱이 사용하는 메모리
		c = new int[n+1]; //재실행 시 드는 비용
		for(int i = 1; i <= n; i++) {
			mem[i] = sc.nextInt();
		}
		int hap = 0;
		for(int i = 1; i <= n; i++) {
			c[i] = sc.nextInt();
			hap += c[i];
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		int dp[][] = new int[n+1][hap+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= hap; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-c[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-c[i]]+mem[i]);
				}
				if(dp[i][j] >= m) {
					ans.add(j);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.get(0));
	}
}
