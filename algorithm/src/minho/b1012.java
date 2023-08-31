package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1012{
	
	static int N, M, K;
	static int[] dir = {0,-1,0,1};
	static int[] diry = {-1,0,1,0};
	static boolean[][] map;
	
	public static void DFS(int x,int y) {
		map[x][y] = false;
		for(int d = 0 ; d < 4 ; d++) {
			if(x+dir[d] >= 0 && x+dir[d]<N && y+diry[d] >= 0 && y+diry[d] < M
					&& map[x+dir[d]][y+diry[d]]) {
				map[x+dir[d]][y+diry[d]] = false;
				DFS(x+dir[d],y+diry[d]);
			}
		}
	}
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
                
        for(int t = 0 ; t < T ; t++) {
        	
        	int cnt = 0;
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	map = new boolean[N][M];
        	
        	for(int i = 0 ; i < K ; i++) {
       
        		st = new StringTokenizer(br.readLine());
        		map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
              		
        	}
        	
        	for(int i = 0 ; i < N ; i++) {
        		for(int j = 0 ; j < M ; j++) {
        			if(map[i][j]) { DFS(i,j); cnt++;}
        		}
        	}
        	
        	System.out.println(cnt);	
        } 
    }
}


