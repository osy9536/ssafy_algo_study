import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node> arr[];
	static boolean visit[];
	static int dist[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[p].add(new Node(c, value));
			arr[c].add(new Node(p, value));
		}
		visit = new boolean[N+1];
		dist = new int[N+1];
		bfs(1);
		int max = 1;
		for(int i = 2; i <= N; i++) {
			max = dist[max] < dist[i]? i : max;
		}
		visit = new boolean[N+1];
		dist = new int[N+1];
		bfs(max); int max_v = 0;
		for(int i = 1; i < dist.length; i++) {
			max_v = max_v < dist[i]? dist[i] : max_v;
		}
		System.out.println(max_v);
	}
	static class Node{
		int c, value;
		public Node(int c, int value){
			this.c = c;
			this.value = value;
		}
	}
	static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		visit[idx] = true;
		q.add(idx);
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(Node next: arr[temp]) {
				int c = next.c;
				int value = next.value;
				if(!visit[c]) {
					visit[c] = true;
					q.add(c);
					dist[c] = dist[temp] + value;
				}
			}
		}
	}
}
