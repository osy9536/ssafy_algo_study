import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260 {
	static ArrayList<Integer>[] A;
	static int N;
	static int M;
	static int V;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//입력값 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		A = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		//인접리스트로 구현
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}
		//오름차순으로 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		visited = new boolean[N+1];
		DFS(V);
		System.out.println();
		visited = new boolean[N+1];
		BFS(V);
	}

	static void DFS(int Node) {
		System.out.print(Node + " ");
		visited[Node] = true;
		for(int i: A[Node]){
			if(!visited[i]){
				DFS(i);
			}
		}
	}

	static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node] = true;
		
		while(!queue.isEmpty()) {
			int now_Node = queue.poll();
			System.out.print(now_Node + " ");
			for(int i: A[now_Node]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
