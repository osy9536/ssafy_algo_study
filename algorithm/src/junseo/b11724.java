package algorithm.src.junseo;
package algo;

import java.io.*;
import java.util.*;

public class b11724_연결요소의개수 {
	
	static List<Integer>[] list;
	static int N,M;
	static boolean [] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		vis = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
			
			
		}
		
		int cnt = 0;
		
		for (int i = 1; i <=N; i++) {
			if(!vis[i]) {
				DFS(i);
				cnt++;
			}
		}
		System.out.println(cnt);

		
	}
	private static void DFS(int cur) {
		
		if(vis[cur]) return;
		else {
			vis[cur] = true;
		}
		for (int i = 0; i < list[cur].size(); i++) {
			DFS(list[cur].get(i));
		}
	}

}

