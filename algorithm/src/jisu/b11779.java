package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b11779 {
	static int n;
	static int m;

	static int INF = Integer.MAX_VALUE;

	static int[] dij;
	static boolean[] visit;
	static List<List<Node>> list;
	static Queue<Node> que = new PriorityQueue<>();

	static class Node implements Comparable<Node> {
		int end, weight;
		List<Integer> route = new ArrayList<>();

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		public Node(int end, int weight, List<Integer> route) {
			this.end = end;
			this.weight = weight;
			this.route = route;
		}

		@Override
		public int compareTo(Node o) {
			if (this.weight == o.weight)
				return this.end - o.end;
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		dij = new int[n + 1];
		visit = new boolean[n+1];
		list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			dij[i] = INF;
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int de = Integer.parseInt(st.nextToken());
			int ar = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list.get(de).add(new Node(ar, len));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dij[start] = 0;
		List<Integer> a = new ArrayList<>();
		a.add(start);
		List<Integer> resultRoute = new ArrayList<>();
		que.add(new Node(start, 0, a));

		while (!que.isEmpty()) {
			Node now = que.poll();
			if (visit[now.end])
				continue;
			visit[now.end] = true;
			for (Node node : list.get(now.end)) {
				int len = now.weight + node.weight;
				if (dij[node.end] > len) {
					List<Integer> newList = new ArrayList<>();
					if (!visit[node.end]) {
						newList = new ArrayList<>();
						newList.addAll(now.route);
						newList.add(node.end);
						que.add(new Node(node.end, len, newList));
					}
					dij[node.end] = len;
					if (node.end == end) {
						resultRoute.clear();
						resultRoute.addAll(newList);
					}
						
				}
			}
		}

		System.out.println(dij[end]);
		System.out.println(resultRoute.size());
		for (int i : resultRoute) {
			System.out.print(i + " ");
		}

	}
}
