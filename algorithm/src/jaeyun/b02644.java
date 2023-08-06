package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b02644 {
	static int ans;
	static ArrayList<Integer>[] nodes;
	static boolean [] visited;
	static boolean found;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int x, y;
		nodes = new ArrayList[n+1];
		visited = new boolean[n+1];
		found = false;
		for (int i=0; i<=n; i++) {
			nodes[i] = new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			nodes[x].add(y);
			nodes[y].add(x);
		}
		ans = -1;
		visited[start] = true;
		dfs(start, end, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int node, int end, int depth) {
		for (int i=0; i<nodes[node].size(); i++) {
			if (visited[nodes[node].get(i)]) continue;
			if (found) return;
			if (nodes[node].get(i) == end) {
				ans = depth+1;
				found = true;
				return;
			}
			else {
				visited[nodes[node].get(i)] = true;
//				System.out.println("dfs "+nodes[node].get(i));
				dfs(nodes[node].get(i), end, depth+1);
			}
		}
	}
}
