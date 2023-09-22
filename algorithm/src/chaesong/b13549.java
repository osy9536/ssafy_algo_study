import java.util.*;
import java.io.*;

public class b13549 {
	static int N, K, ans;
	static boolean visit[];
	static class Node implements Comparable<Node>{
		int now, depth;
		public Node(int now, int depth) {
			this.now = now;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Node [now=" + now + ", depth=" + depth + "]";
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.depth-o.depth;
		}
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visit = new boolean[100_000 + 1];
		ans = 100_000;
		sumba(N, 0);
		System.out.println(ans);
	}
	static void sumba(int now, int depth) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(now, depth));
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			visit[tmp.now] = true;
			if(tmp.now == K) {
				ans = tmp.depth; 
				return;
			}
			int nxt[] = {tmp.now*2, tmp.now-1, tmp.now+1};
			for(int i = 0; i < 3; i++) {
				if(0 <= nxt[i] && nxt[i] <= 100_000 && !visit[nxt[i]]) { // 범위 안에 있으면서 한번도 방문하지 않은 곳이면
					if(i >= 1) q.add(new Node(nxt[i], tmp.depth+1));
					else q.add(new Node(nxt[i], tmp.depth));
				}
			}
		}
	}
}
 
