package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,K,count =0;
		boolean[] isVisited;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		isVisited = new boolean[200005];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		if( N == K) {
			System.out.println(0);
			return;
		}
		here : while(true) {
			int qsize = q.size();
			for(int i = 0 ; i < qsize ; i++) {
				int n = q.poll();
				if(n-1 == K || n*2 == K || n+1 == K) {
					count++;
					break here;
				}
				if(n-1 >=0 && !isVisited[n-1]) {
					isVisited[n-1] = true;
					q.add(n-1);
				}
				if(n+1 < 200005 && !isVisited[n+1]) {
					isVisited[n+1] = true;
					q.add(n+1);
				}
				if(n*2 < 200005 && !isVisited[n*2]) {
					isVisited[n*2] = true;
					q.add(n*2);
				}
				
			}
			count++;
		}
		System.out.println(count);
	}
}