import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b2606 {
	static int N; static int M;
	static ArrayList<Integer> my[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		my = new ArrayList[N+1];
		visited = new boolean[N+1];
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			my[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 my[a].add(b);
			 my[b].add(a);
		}
		
		DFS(1);
		
		int ans = 0;
		for(int i = 2; i <= N; i++) {
			if(visited[i]) ans++;
		}
		
		System.out.println(ans);
		
	}
	static void DFS(int Node) {
		visited[Node] = true;
		for(int i : my[Node]) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(i);
			}
		}
	}
}
