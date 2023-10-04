package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 키 순서
// d4
public class s5643 {
	static int N, M, outCnt;
	static int[] answer;
	static List<Integer>[] list;
	static int[] count;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			list = new ArrayList[N + 1];
			answer = new int[N + 1];
			count = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);

			}
			for (int i = 1; i <= N; i++) {
				outCnt=0;
				visited = new boolean[N + 1];
				visited[i] =true;
				DFS(i);
				answer[i] +=outCnt;
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (answer[i] == N) {
					cnt++;
				}
			}
			System.out.println(Arrays.toString(answer));
			System.out.println("#" + t + " " + cnt);
		}
	}

	private static void DFS(int start) {
		outCnt++;
		for(int n : list[start]) {
			if(visited[n]) continue;
			visited[n] = true;
			answer[n]++;
			DFS(n);
		}
	}
}
