package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b13023 {
	static List<Integer>[] nodes;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start, end;
		nodes = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i=0; i<=N; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			nodes[start].add(end);
			nodes[end].add(start);
		}
		
		for (int i=0; i<N; i++) {
			visited[i] = true;
			dfs(i, 0);
			visited[i] = false;
		}
		System.out.println(0);
	}
	public static void dfs(int cur, int depth) {
		if (depth == 4) {
			System.out.println(1);
			System.exit(0);
		}
		for (int i=0; i<nodes[cur].size(); i++) {
			if (!visited[nodes[cur].get(i)]) {
				visited[nodes[cur].get(i)] = true;
				dfs(nodes[cur].get(i), depth+1);
				visited[nodes[cur].get(i)] = false;
			}
		}
	}
}
