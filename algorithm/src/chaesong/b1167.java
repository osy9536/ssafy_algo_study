import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static ArrayList<Node> my[];
	static boolean visit[];
	static int dist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		my = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			my[i] = new ArrayList<>();
		}
		for(int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				if(e == -1) break;
				int d = Integer.parseInt(st.nextToken());
				my[s].add(new Node(e, d));
			}
		}
		visit = new boolean[V+1];
		dist = new int[V+1];
		bfs(1);
		int max = 1;
		for(int i = 2; i <= V; i++) {
			if(dist[max] < dist[i]) max = i;
		}
		dist = new int[V+1];
		visit = new boolean[V+1];
		bfs(max);
		Arrays.sort(dist);
		System.out.println(dist[V]);
	}
	//노드 정보 담고 있는 클래스
	static class Node{
		int e, value; //e는 연결된 노드, d는 거리
		public Node(int e, int value) {
			this.e = e;
			this.value = value;
		}
	}
	//idx에서 갈 수 있는 최대 거리 저장하기
	static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visit[idx] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(Node next: my[temp]) {
				int e = next.e;
				int value = next.value;
				if(!visit[e]) {
					visit[e] = true;
					q.add(e);
					dist[e] = dist[temp] + value;
				}
			}
		}
	}
}
