import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b11724 {
	//들렀는지 안들렀는지 확인하려고
	static boolean visited[];
	//노드 배열
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		//노드 개수
		int N = Integer.parseInt(st.nextToken());
		//에지 개수
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		//에지개수만큼 돌면서 리스트에 넣어주기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[b].add(a);
			A[a].add(b); //양방향 노드이니까 둘다 넣어줘야 함
		}
		int cnt = 0;
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				cnt++;
				DFS(i);
			}
		}
		System.out.println(cnt);
		
	}
	static void DFS(int v) {
		//방문했다면
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int i : A[v]) {
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}
}
