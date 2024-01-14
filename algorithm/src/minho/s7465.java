package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s7465{
	static int[] parent;
	static boolean[] isVisited;
	private static void Union(int x, int y) {
		x = Find(x);
		y = Find(y);
		
		if(x==y) return;
		
		if(x < y) parent[y]=x;
		else parent[x]=y;
	}
	private static int Find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = Find(parent[x]);
	}
	private static boolean isUnion(int x, int y){
		x = Find(x);
		y = Find(y);
		
		return (x==y);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < TC ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			isVisited = new boolean[n+1];
			for(int i = 1 ; i <= n ; i++) {
				parent[i]=i;
			}
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Union(a,b);
			}
			int cnt =0 ;
			for(int i = 1 ; i <= n; i++) {
				if(!isVisited[Find(i)]) {
					cnt++;
					isVisited[Find(i)]=true;
				}
			}
			System.out.println("#"+(t+1)+" "+cnt);
			
		}
	}
}