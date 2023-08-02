package algorithm.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260 {
	static boolean checked[];
	static int n,m,v;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		checked = new boolean[n+1];
		for(int i = 0;i<m;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		DFS(v);
		sb.append("\n");
		checked = new boolean[n+1];
		BFS(v);
		System.out.println(sb);
	}
	public static void DFS(int x) {
		sb.append(x+" ");
		checked[x]=true;
		for(int i=0;i<=n;i++) {
			if(!checked[i] && arr[x][i]==1) {
				DFS(i);
			}
		}
	}
	public static void BFS(int x) {
		q.add(x);
		checked[x]=true;
		while(!q.isEmpty()) {
			x=q.poll();
			sb.append(x+" ");
			for(int i = 1 ; i<=n;i++) {
				if(!checked[i] && arr[x][i]==1) {
					q.add(i);
					checked[i] = true;
				}
			}
		}
	}
}
