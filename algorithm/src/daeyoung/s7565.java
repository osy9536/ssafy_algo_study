package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * sw 7565
 * 창용 마을 무리의 개수
 */
public class s7565 {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); // 사람 수
			int m = Integer.parseInt(st.nextToken()); // 관계 수
			
			parent = new int[n + 1];
			
			for(int i = 1; i < n + 1; i++)
				parent[i] = i;
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				union(x, y);
			}
			
			int a = 0;
			for(int i = 1; i < n + 1; i++)
				if(parent[i] == i)
					a++;
			
			sb.append("#").append(tc).append(" ").append(a).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y)
			return false;
		
		if(x <= y) 
			parent[y] = x;
		else
			parent[x] = y;
		
		return true;
	}
	
	public static int find(int x) {
		if(parent[x] == x) 
			return x;
		return find(parent[x]);
	}
}
