package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b11403 {
	static int n, m;
	static int[][] mat;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		mat = new int[n][n];
		List<Integer>[] link = new ArrayList[n];
		for (int i = 0; i < link.length; i++) {
			link[i] = new ArrayList<>();
		}
		int[][] result = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if (mat[i][j]==1) {
					link[i].add(j);
					result[i][j] = 1;
				}
			}
		}
		
		Queue<Integer> que = new LinkedList<>();
		List<Set<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			visit = new boolean[n];
			que.clear();
			que.add(i);
			while(!que.isEmpty()) {
				int now = que.poll();
				for (int j : link[now]) {
					if (visit[j]) continue;
					que.add(j);
					visit[j] = true;
					result[i][j] = 1;
				}
			}
//			visit[i] = true;
		}
		
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (result[i][j] == 1) continue;
//				for (Set set : list) {
//					if (set.contains(i) && set.contains(j)) {
//						result[i][j] = 1;
//						result[j][i] = 1;
//						break;
//					}
//				}
//			}
//		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
