package algorithm.src.junseo;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list;
		list = new ArrayList[N + 1];
        
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
        
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
		}

		PriorityQueue<Integer> l = new PriorityQueue<>();
		int max = -1;

		for (int i = 1; i <= N; i++) {
			if (list[i].size() != 0) {
				int cnt = BFS(list, i, N);
				if (cnt < max)
					continue;

				if (cnt > max) {
					max = cnt;
					l = new PriorityQueue<>();
					l.add(i);
				} else if (cnt == max)
					l.add(i);
			}

		}
		for (int i : l)
			sb.append(i + " ");
		System.out.println(sb);
	}

	private static int BFS(ArrayList<Integer>[] list, int idx, int N) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] vis = new boolean[N + 1];
		vis[idx] = true;
		queue.add(idx);
		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			cnt++;
			for (int a : list[cur]) {
				if (vis[a])
					continue;
				queue.add(a);
				vis[a] = true;

			}
		}
		return cnt;
	}
}


