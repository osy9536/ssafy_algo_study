package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b16928 {
	static int n, m, result;
	static int[] visit;
	static Map<Integer, Integer> map;
	
	static class Hi{
		int num, cnt;
		public Hi(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static void dfs(int now, int cnt) {
		if (cnt > result) return;
		if (now > 100) return;
		if (now == 100) {
			if (cnt < result) result = cnt;
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			int next = now + i;
			if (map.containsKey(now+i)) {
				next = map.get(now+i);
			}
			
			if (100 < next || visit[next] < cnt + 1) continue;
			visit[next] = cnt+1;
			dfs(next, cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		visit = new int[101];
		for (int i = 0; i < 101; i++) {
			visit[i] = Integer.MAX_VALUE;
		}
		map = new HashMap<>();
		
		for (int i = 0; i < n+m; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		dfs(1, 0);
		
		System.out.println(result);
	}
}
