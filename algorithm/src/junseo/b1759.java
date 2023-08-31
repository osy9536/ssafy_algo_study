package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기 {
	
	static int L,C;
	static char[] arr;
	static char[] ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		//////////////////////////////////////////////////////
		
		
		ans = new char[L];
		visited = new boolean[C];
		Arrays.sort(arr);
		dfs(0,0);
		
	}
	static void dfs(int x,int cnt) {
		if(cnt >= L) {
			int mcnt = 0;
			int jcnt = 0;
			for (int i = 0; i < L; i++) {
				if(ans[i] == 'a' ||ans[i] == 'e' ||ans[i] == 'i' ||ans[i] == 'o' ||ans[i] == 'u') mcnt++;
				else jcnt++;
					
			}
			if(jcnt<2 || mcnt<1) return;
			else {
				print();
			}
		} 
		else {
			for (int i = x; i < C; i++) {
				if (!visited[i]) {
					visited[i] = true;
					ans[cnt] = arr[i];
					dfs(i, cnt + 1);
					visited[i] = false;
				}
			}
		}
	}
	static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]);
		}
		System.out.println();
	}
	static void print2() {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}	
}

