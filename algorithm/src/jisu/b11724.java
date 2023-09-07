package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11724 { 
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> link = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			link.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			link.get(one).add(two);
			link.get(two).add(one);
		}
		
		boolean[] visit = new boolean[n+1];
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			if (visit[i]) continue;
			
			cnt++;
			que.add(i);
			visit[i] = true;
			
			while (!que.isEmpty()) {
				int now = que.poll();
				for(int next : link.get(now)) {
					if (visit[next]) continue;
					que.add(next);
					visit[next] = true;
				}
			}
		}
		
		
		System.out.println(cnt);
	}
}

