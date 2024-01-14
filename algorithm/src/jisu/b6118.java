package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b6118 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int INF = Integer.MAX_VALUE;
		
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int[] dij = new int[n+1];
		boolean[] visit = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			dij[i] = INF;
		}
		dij[1] = 0;
		que.add(new int[] {1, 0});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			if (visit[now[0]]) continue;
			visit[now[0]] = true;
			for (int next : list.get(now[0])) {
				if (dij[next] <= now[1] + 1) continue;
				dij[next] = now[1] + 1;
				if (!visit[next]) que.add(new int[] {next, dij[next]});
			}
		}
		
		int maxi = -INF;
		int maxiIdx = 0;
		int maxiCnt = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = dij[i];
			if (cnt > maxi) {
				maxi = cnt;
				maxiIdx = i;
				maxiCnt = 1;
			} else if (cnt == maxi) {
				maxiCnt++;
			}
		}
		
		System.out.println(maxiIdx + " " + maxi + " " + maxiCnt);
	}
}
