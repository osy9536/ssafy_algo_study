package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static final int INF = (int)1e9;
	static int N;
	static int [][] arr,dp;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[1<<N][N];//마지막 도시에서 다시 시작점으로 이동하는 비용또한 저장
		for (int[] row : dp) {
			//이전에 그 도시를 방문하면서 기록한 값이 있는지 확인하기 위함
			Arrays.fill(row, -1);
		}
		
		System.out.println(dfs(1,0));
	}


	private static int dfs(int mask, int cur) {
		if(mask == (1<<N)-1) {
			if(arr[cur][0] != 0) {
				return arr[cur][0];
			}
			return INF;	
		}
		
		if(dp[mask][cur] != -1) return dp[mask][cur];
		
		int cost = INF;
		
		for (int i = 0; i < N; i++) {
			if((mask & (1<<i)) == 0 && arr[cur][i ]!= 0) {
				cost = Math.min(cost, dfs(mask | (1<<i),i)+arr[cur][i]);
			}
		}
		dp[mask][cur] = cost;
		return cost;
		
	}
}


