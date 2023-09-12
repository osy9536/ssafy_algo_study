package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16928 {
	static int[] map;
	static int[] count;
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M ;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int sum = N+M;
		map = new int[101];
		isVisited = new boolean[101];
		count = new int[101];
		for(int i = 1 ; i <= sum ; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		count[1]=0;
		isVisited[1]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now ==100){
				System.out.println(count[now]);
				break;
			}
			for(int i = 1 ; i <= 6 ; i++) {
				int next = now+i;
				if(next > 100 || isVisited[next]) continue;
				if(map[next]!=0) {
					if(!isVisited[map[next]]) {
						isVisited[map[next]]=true;
						count[map[next]]=count[now]+1;
						q.add(map[next]);
					}
				}
				else {
					isVisited[next]=true;
					count[next]=count[now]+1;
					q.add(next);
				
				}
			}
		}
	}
}
