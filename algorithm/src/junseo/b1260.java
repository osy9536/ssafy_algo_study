package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS {

	static int N,M,V;
	static boolean[] visited;
	static List<ArrayList<Integer>> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
			//list.get(i).add(i);
		}
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for (int i = 1; i <= N; i++) {
			list.get(i).sort((o1,o2)->(o1-o2));
		}
		
		//////////////////////////////////////////////////////
		
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs();
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[V] = true;
		sb.append(V).append(" ");
		queue.add(V);
		for (int i = 0; i < list.get(V).size(); i++) {
			queue.add(list.get(V).get(i));
			visited[list.get(V).get(i)] = true;
			sb.append(list.get(V).get(i)).append(" ");
		}
		while(!queue.isEmpty()) {
			int a = queue.poll();
			for (int i = 0; i < list.get(a).size(); i++) {
				if(!visited[list.get(a).get(i)]) {
					queue.add(list.get(a).get(i));
					visited[list.get(a).get(i)] = true;
					sb.append(list.get(a).get(i)).append(" ");
				}
			}
		}
	}

	private static void dfs(int x) {
		visited[x] = true;
		sb.append(x).append(" ");
		for (int j = 0; j < list.get(x).size(); j++) {
			if (!visited[list.get(x).get(j)]) {
				dfs(list.get(x).get(j));
				// visited[list.get(i).get(j)] = false;
			}
		}

	}
}

