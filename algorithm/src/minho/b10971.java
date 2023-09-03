package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10971{
	static int N,sum,ans=Integer.MAX_VALUE,star;
	static int[][] MAP;
	static boolean[] isVisited;
	public static void DFS(int start,int cnt) {
		if(cnt==N-1) {
			if(MAP[start][star]==0) return;
			sum+=MAP[start][star];
			ans = (ans > sum) ? sum : ans;
			sum-=MAP[start][star];
			return;
		}
		for(int i = 0 ; i < N; i++) {
			if(MAP[start][i]!=0 && !isVisited[i]) {
				isVisited[i] = true;
				sum+=MAP[start][i];
				DFS(i,cnt+1);
				sum-=MAP[start][i];
				isVisited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		MAP = new int [N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			sum=0;
			isVisited = new boolean[N];
			isVisited[i] = true;
			star= i;
			DFS(i,0);
			isVisited[i] = false;
		}
		System.out.println(ans);
    }
}


