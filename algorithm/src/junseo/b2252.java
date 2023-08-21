package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b2252 {
	private static boolean[] visited = null;
	static int N,M;
	static List <ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for (int i = 0; i <N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			list.get(b).add(a);
			
		}
		////////////////////////////////////////////////////
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			dfs(i);
		}
		
		
	}
	private static void dfs(int idx) {
		if(list.get(idx).size() == 0 && !visited[idx]) {
			visited[idx] = true;
			System.out.print(idx+1+" ");
			return;
		}
		int i = 0;
		while(!list.get(idx).isEmpty()) {
			int val = list.get(idx).get(i);
			list.get(idx).remove(i);
			dfs(val);
			dfs(idx);
		}

	}

}


