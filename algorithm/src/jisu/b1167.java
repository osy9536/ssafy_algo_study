package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1167 { 
    static int n;
    static int[][] map;
    static boolean[] visit;
    static int result = 0;
    
    static class node {
    	int num;
    	int len;
    	public node(int num, int len) {
    		this.num = num;
    		this.len = len;
    	}
    }
    
    static List<node>[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
        
        for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int de = Integer.parseInt(st.nextToken());
			while (true) {
				int ar = Integer.parseInt(st.nextToken());
				if (ar == -1) break;
				int guri = Integer.parseInt(st.nextToken());
				tree[de].add(new node(ar, guri));
			}
		}
        
        
        visit = new boolean[n+1];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {1, 0});
        visit[1] = true;
        int maxi = 0;
        int maxinode = 0;
        while (!que.isEmpty()) {
        	int[] now = que.poll();
        	for (node a : tree[now[0]]) {
        		if (visit[a.num]) continue;
        		visit[a.num] = true;
        		int newlen = now[1]+a.len;
        		if (maxi < newlen) {
        			maxinode = a.num;
        			maxi = newlen;
        		}
        		que.add(new int[] {a.num, newlen});
        	}
        }
        
        visit = new boolean[n+1];
        visit[maxinode] = true;
        maxi = 0;
        int resultnode = 0;
        que.add(new int[] {maxinode, 0});
        while (!que.isEmpty()) {
        	int[] now = que.poll();
        	for (node a : tree[now[0]]) {
        		if (visit[a.num]) continue;
        		visit[a.num] = true;
        		int newlen = now[1]+a.len;
        		if (maxi < newlen) {
        			resultnode = a.num;
        			maxi = newlen;
        		}
        		que.add(new int[] {a.num, newlen});
        	}
        }
        System.out.println(maxi);
        
        
    }
}