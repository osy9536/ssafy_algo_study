package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b7562 {
	public static int l;
	public static int[] now;
	public static int[] want;
	public static boolean[][] visit;
	
	public static int[][] dr = {{1,2,2,1,-1,-2,-2,-1},{2,1,-1,-2,-2,-1,1,2}};
	
	public static boolean isout(int[] wv) {
		for (int i = 0; i < 2; i++) {
			if (wv[i] < 0 || wv[i] >= l) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			l = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			now = new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])};
			s = br.readLine().split(" ");
			want = new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])};
			
			visit = new boolean[l][l];
			Queue<int[]> que = new LinkedList<int[]>(); 
			Queue<Integer> cntque = new LinkedList<>(); 
			
			int result = 0;
			
			
			que.add(now);
			cntque.add(0);
			visit[now[0]][now[1]] = true;
			
			while (!que.isEmpty()) {
				int[] pop = que.poll();
				int cnt = cntque.poll();
				if (pop[0] == want[0] && pop[1] == want[1]) {
					result = cnt;
					break;
				}
				
				for (int i = 0; i < dr[0].length; i++) {
					int y = pop[0]+dr[0][i];
					int x = pop[1]+dr[1][i];
					if (isout(new int[] {y,x}) || visit[y][x]) continue;
					que.add(new int[] {y,x});
					cntque.add(cnt+1);
					visit[y][x] = true;
				}
			}
			
			System.out.println(result);
		}
		
	}
}
