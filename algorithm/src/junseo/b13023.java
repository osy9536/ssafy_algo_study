package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_13023_친구관계파악하기 {
	
	static int N,M;
	static List <ArrayList<Integer>> list;
	static int res;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		/////////////////////////////////////////////////////////////////
		res = 0;
		visited = new boolean[N];
		for (int i = 0; i < list.size() && res == 0; i++) {
			dfs(i,0);
		}
		System.out.println(res);
	}
	private static void dfs(int x,int cnt) {
		if(res == 1) return;
		if(cnt >= 5) {
			res = 1;
			return;
		}
		else {
			int size = list.get(x).size();
			for (int i = 0; i < size; i++) {
				int next = list.get(x).get(i);
				if (!visited[next]) {
						visited[next] = true;
						dfs(next, cnt + 1);
						visited[next] = false;
					}
				
			}
		}
	}

}

