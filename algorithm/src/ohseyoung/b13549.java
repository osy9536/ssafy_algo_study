package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 3
// gold 5
public class b13549 {
	static class Node {
		int now, depth;

		Node(int now, int depth) {
			this.now = now;
			this.depth = depth;
		}
	}

	static int[] visited;
	static int cnt;
	static int answer;
	static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		answer = Integer.MAX_VALUE;
		cnt = 1;
		BFS(N);
		System.out.println(answer);
	}

	static void BFS(int start) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.depth>answer)continue;

			if (K == cur.now) {
				if (answer > cur.depth) {
					answer = cur.depth;
					cnt = 1;
				} else if (answer == cur.depth) {
					cnt++;
					continue;
				}
			}
			int[] arr= {cur.now-1, cur.now+1, cur.now*2};
			for(int i = 0; i<3; i++) {
				int next = arr[i];
				if(next>=0&&next<100001) {
					if(visited[next]==0||visited[next]==cur.depth+1) {
						visited[next]=cur.depth+1;
						if(i==2) q.add(new Node(next,cur.depth));
						else q.add(new Node(next,cur.depth+1));
					}
				}
			}
		}
	}
}
