package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

// 최소비용 구하기 2
// gold 3
public class b11779 {
	
	static Function<String, Integer> stoi = Integer::parseInt;
	static int N, M, start, end;
	static ArrayList<int[]> routes[];
	static int[] dp, prev;
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = stoi.apply(br.readLine());
		M = stoi.apply(br.readLine());
		routes = new ArrayList[N + 1];
		dp = new int[N + 1];
		prev = new int[N + 1];
		Arrays.fill(dp, INF);
		for (int i = 1; i <= N; i++) {
			routes[i] = new ArrayList<int[]>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			routes[stoi.apply(st.nextToken())]
					.add(new int[] { stoi.apply(st.nextToken()), stoi.apply(st.nextToken()) });
		}
		st = new StringTokenizer(br.readLine());
		start = stoi.apply(st.nextToken());
		end = stoi.apply(st.nextToken());
		dijk();
		trace();
	}

	private static void trace() {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.add(end);
		while (true) {
			if (end == start) {
				break;
			}
			stack.add(prev[end]);
			end = prev[end];
		}
		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			System.out.print(stack.pollLast() + " ");
		}
	}

	private static void dijk() {
		PriorityQueue<int[]> pQ = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
		pQ.add(new int[] { start, 0 });
		dp[start] = 0;

		while (!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if (dp[cur[0]] < cur[1]) {
				continue;
			}
			if (cur[0] == end) {
				break;
			}
			for (int[] e : routes[cur[0]]) {
				if (dp[e[0]] > e[1] + dp[cur[0]]) {
					dp[e[0]] = e[1] + cur[1];
					pQ.add(new int[] { e[0], dp[e[0]] });
					prev[e[0]] = cur[0];
				}
			}
		}
		System.out.println(dp[end]);
	}
}
