package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b9372 { 
	static int n;
	static int m;
	static int x;
	
    static int[][] map;
    static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			List<Integer>[] arr = new ArrayList[n+1];
			for (int i = 0; i <= n; i++) {
				arr[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				arr[one].add(two);
				arr[two].add(one);
			}
			
			visit = new boolean[n+1];
			visit[1] = true;
			int allvisit = n-1;
			int cnt = 0;
			Queue<int[]> que = new LinkedList<int[]>();
			que.add(new int[] {1, 0});
			while (!que.isEmpty()) {
				int[] now = que.poll();
				if (allvisit == 0) {
					System.out.println(cnt);
					break;
				}
				for (int i : arr[now[0]]) {
					if (visit[i]) continue;
					visit[i] = true;
					allvisit--;
					cnt++;
					que.add(new int[] {i, now[1]+1});
				}
			}
		}
	}
}
