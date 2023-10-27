package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1707_이분그래프 {
	static int V,E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			List<Integer>[] list;
			list = new ArrayList[V+1];
			
			for (int i = 1 ; i <= V; i++) {
				list[i] = new ArrayList<>(); 
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			int[] vis;
			vis = new int[V+1];
			boolean flag = true;
			for (int i = 1; i <= V; i++) {
				if(vis[i] == 0) {
					if(!BFS(i,vis,list)) {
						flag = false;
						break;
					}
				}
				if(!flag)break;
			}
			
			if(flag) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		
		}
		System.out.println(sb);
		
	}

	private static boolean BFS(int idx, int[] vis, List<Integer>[] list) {
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(idx);
		int[] visCopy;
		visCopy = new int[V+1];
		boolean flag = true;
		for (int i = 0; i <= V; i++) {
			visCopy[i] = vis[i];
		}
		visCopy[idx] = 1;
		
		while(!queue.isEmpty()&&flag) {
			int cur = queue.poll();
			
			for (int val : list[cur]) {
				if(visCopy[val] == 0) {
					queue.add(val);
					visCopy[val] = visCopy[cur]*-1;
				}
				else if(visCopy[val] == visCopy[cur]) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			for (int i = 0; i <= V; i++) {
				vis[i] = visCopy[i];
			}
			return flag;
		}
		
		else {
			visCopy = new int[V+1];
			for (int i = 0; i <= V; i++) {
				visCopy[i] = vis[i];
			}
			visCopy[idx] = -1;
			flag = true;
			queue = new ArrayDeque<>();
			queue.add(idx);
			while(!queue.isEmpty()&&flag) {
				int cur = queue.poll();	
				for (int val : list[cur]) {
					if(visCopy[val] == 0) {
						queue.add(val);
						visCopy[val] = visCopy[cur]*-1;
					}
					else if(visCopy[val] == visCopy[cur]) {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				for (int i = 0; i <= V; i++) {
					vis[i] = visCopy[i];
				}
			}
			return flag;
		}

	}

}


