package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b13700 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if (k != 0) st = new StringTokenizer(br.readLine());
		Set<Integer> polices = new HashSet<>();
		for (int i = 0; i < k; i++) {
			polices.add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<int[]> que = new ArrayDeque<>();
		boolean[] visit = new boolean[n+1];
		visit[s] = true;
		que.add(new int[] {s, 0});
		
		String answer = "BUG FOUND";
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			if (now[0] == d) {
				answer = now[1] + "";
				break;
			}
			
			int front = now[0] + f;
			int back = now[0] - b;
			if (front <= n && !visit[front] && !polices.contains(front)) {
				que.add(new int[] {front, now[1]+1});
				visit[front] = true;
			}
			if (back >= 1 && !visit[back] && !polices.contains(back)) {
				que.add(new int[] {back, now[1]+1});
				visit[back] = true;
			}
		}
		
		System.out.println(answer);
		
	}
}
