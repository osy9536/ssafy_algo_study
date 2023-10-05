package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<ArrayList<Integer>> list1;
	static List<ArrayList<Integer>> list2;
	static boolean[] visited;
	static int N;
	static int M;
	static int cnt;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		res = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			// ArrayList<Integer> temp = new ArrayList<>();
			list1.add(new ArrayList<>());
			list2.add(new ArrayList<>());// list1의 각 원소에 새로운 ArrayList를 추가
			// list2.add(temp);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list1.get(a).add(b); // a가 가리키고 있는 b
			list2.get(b).add(a); // b를 가리키고 있는 a
		}

		// -----------------------------------------------------------------------

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			cnt = 0;
			visited[i] = true;
			bfs(list1, i);
			bfs(list2, i);
			if (cnt == N - 1) {
				// System.out.println(i);
				res++;
			}
		}
		System.out.println(res);
	}

	private static void bfs(List<ArrayList<Integer>> list, int idx) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(idx);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < list.get(cur).size(); i++) {
				int val = list.get(cur).get(i);
				if (!visited[val]) {
					visited[val] = true;
					queue.add(val);
					cnt++;
				}
			}
		}
	}
}



