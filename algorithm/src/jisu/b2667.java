package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class b2667 {
	public static boolean isin(int[] next, int n) {
		for (int i = 0; i < 2; i++) {
			if (next[i] < 0 || next[i] >= n) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		StringTokenizer st = new StringTokenizer(br.readLine(), "");
		
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < s.length; j++) {
				house[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[][] dr = {{0,1,0,-1},{1,0,-1,0}};
		
		Queue<int[]> que = new LinkedList<int[]>();
		int[][] visit = new int[n][n];
		
		int cnt = 0;
		List<Integer> danji = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j]==1 || house[i][j] == 0) continue;
				
				que.add(new int[] {i, j});
				cnt++;
				danji.add(1);
				visit[i][j] = 1;
				while(que.size()!=0) {
					int[] now = que.poll();
					
					for (int k = 0; k < 4; k++) {
						int y = now[0]+dr[0][k];
						int x = now[1]+dr[1][k];
						int[] yx = new int[] {y, x};
						
						if ((!isin(yx, n)) || visit[y][x]==1 || house[y][x] == 0) continue;
//						System.out.println(now[0]+","+now[1] +" "+ y+","+x);
						que.add(yx);
						visit[y][x]=1;
						danji.set(cnt-1, danji.get(cnt-1)+1);
					}
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(danji);
		for (int i = 0; i <cnt; i++) {
			System.out.println(danji.get(i));
		}
	}
}
