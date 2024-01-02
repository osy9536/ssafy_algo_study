package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b14562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			Queue<int[]> que = new ArrayDeque<>();
			que.add(new int[] {s, t, 0});
			
			while(!que.isEmpty()) {
				int[] now = que.poll();
				int a = now[0];
				int b = now[1];
				int cnt = now[2];
				if (a == b) {
					System.out.println(cnt);
					break;
				} else if (a > b) {
					continue;
				}
				que.add(new int[] {a*2, b+3, cnt+1});
				que.add(new int[] {a+1, b, cnt+1});
			}
		}
		
	}
}
