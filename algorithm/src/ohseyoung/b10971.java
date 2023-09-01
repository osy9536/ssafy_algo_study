package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10971 {
	static int[][] map;
	static int N;
	static int answer;
	static boolean[] visited;
	static int[] select;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		select = new int[N];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		TSP(0);
		System.out.println(answer);
	}

	static void TSP(int depth) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				if (sum >= answer)
					return;
				int a = map[select[i]][select[i + 1]];
				if (a == 0)
					return;
				sum += a;
			}
			int a = map[select[N - 1]][select[0]];
			if(a==0)return;
			sum += a;
			answer = Math.min(sum, answer);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				select[depth] = i;
				TSP(depth + 1);
				visited[i] = false;
			}
		}
	}
}
