package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 요리사
public class s4012 {
	static int[][] map;
	static boolean[] checked;
	static int N, answer;
	static List<Integer> list1 ;
	static List<Integer> list2 ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			checked = new boolean[N];
			answer = Integer.MAX_VALUE;
			list1 = new ArrayList<>();
			list2 = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			permu(0);
			System.out.println("#"+tc+" "+answer);
		}
	}

	static void permu(int depth) {
		if (depth == N / 2) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (cnt<N/2&&list1.get(cnt) == i) {
					cnt++;
					continue;
				}
				list2.add(i);

			}
//			System.out.println(list2.toString());
			// list1 = {0,3}
			// list2 = {1,2}
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					sum1 += map[list1.get(i)][list1.get(j)];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					sum2 += map[list2.get(i)][list2.get(j)];
				}
			}
			answer = Math.min(answer, Math.abs(sum1 - sum2));
//			System.out.println(answer);
			list2.clear();
//			System.out.println(list2.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!checked[i]) {
				if(list1.size()>0&&list1.get(list1.size()-1)>i)continue;
				checked[i] = true;
				list1.add(i);
//				System.out.println(list1.toString());
				permu(depth + 1);
				list1.remove(list1.size() - 1);
				checked[i] = false;
			}
		}
	}
}
