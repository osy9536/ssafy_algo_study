package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b2251_물통 {
	
	static int[] now = new int[3];
	static boolean [][] vis;
	static boolean [] ans;
	static int[] Sender = {0,0,1,1,2,2};
	static int[] Receiver = {1,2,0,2,0,1};
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());
		
		vis = new boolean[201][201];
		ans = new boolean[201];
		
		BFS();
		for (int i = 0; i < 201; i++) {
			if(ans[i])System.out.print(i +" ");
		}
		

	}
	private static void BFS() {
		ArrayDeque<AB> queue = new ArrayDeque<>();
		queue.add(new AB(0,0));
		vis[0][0] = true;
		ans[now[2]] = true;
		
		while(!queue.isEmpty()) {
			AB p = queue.poll();
			int A = p.A;
			int B = p.B;
			int C = now[2] - A - B;
			
			for (int i = 0; i < 6; i++) {
				int [] next = {A,B,C};
				next[Receiver[i]] += next[Sender[i]];
				next[Sender[i]] = 0;
				if(next[Receiver[i]]>now[Receiver[i]]) {
					next[Sender[i]] = next[Receiver[i]]-now[Receiver[i]];
					next[Receiver[i]]=now[Receiver[i]];
				}
				if(!vis[next[0]][next[1]]) {
					vis[next[0]][next[1]] = true;
					queue.add(new AB(next[0],next[1]));
					if(next[0] == 0) {
						ans[next[2]] = true;
					}
				}
			}
			
			
		}
		
		
		
	}
	static class AB {
		int A;
		int B;
		
		public AB(int A,int B){
			this.A = A;
			this.B = B;
		}
	}

}


