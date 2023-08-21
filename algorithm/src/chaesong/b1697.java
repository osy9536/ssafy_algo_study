import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1697 {
	static int N;
	static int K;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[200_001];
		if(N == K) {
			System.out.println(0);
		}
		else {
			dfs(N, K);
		}
	}
	static void dfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int dist[] = new int[200_001];
		dist[start]++;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 0; i < 3; i++) {
				int next = 0;
				switch(i) {
				case 0: next = now+1; break;
				case 1: next = now-1; break;
				case 2: next = now*2; break;
				}
				if(next == end) {
					System.out.println(dist[now]);
					return;
				}
				if(0 <= next && next < dist.length && dist[next] == 0) {
					q.add(next);
					dist[next] = dist[now] + 1;
				}
			}
		}
	}
}
