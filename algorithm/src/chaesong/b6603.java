import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			int[] S = new int[k];
			for(int i = 0; i < k; i++){
				S[i] = Integer.parseInt(st.nextToken());
			}
			//포함하고 있는지?
			boolean visited[] = new boolean[k];
			subSet(S, visited, 0, 6);
			System.out.println();
		}
	}
	static void subSet(int[] S, boolean[] visited, int depth, int r) {
		
		//다 뽑으면 종료
		if(r == 0) {
			for(int i = 0; i < S.length; i++) {
				if(visited[i] == true) {
					System.out.print(S[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		//depth가 끝에 도달하면 종료
		if(depth == S.length) {
			return;
		}
		
		visited[depth] = true;
		subSet(S, visited, depth+1, r-1);
		
		visited[depth] = false;
		subSet(S, visited, depth+1, r);
	}
}
