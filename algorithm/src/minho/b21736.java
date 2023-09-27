package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Locate{
	int x ,y;
	public Locate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class b21736 {
	static int N , M;
	static char[][] Campusmap;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static boolean[][] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x=0, y=0;
		Campusmap = new char[N][M];
		isVisited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			Campusmap[i] = s.toCharArray();
			if(s.contains("I")){
				for(int j = 0 ; j < M ; j++) {
					if(Campusmap[i][j]=='I') {
						x=i;
						y=j;
					}
				}
			}
		}
		//지도완성
		int cnt = 0;
		Queue<Locate> q = new ArrayDeque<>();
		q.add(new Locate(x,y));
		isVisited[x][y]=true;
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int i = 0 ; i < qsize ; i++) {
				Locate l = q.poll();
				for(int d = 0 ; d < 4; d++) {
					if(l.x+dx[d] >=0 && l.x+dx[d]<N && l.y+dy[d] >=0 && l.y+dy[d]<M 
							&& !isVisited[l.x+dx[d]][l.y+dy[d]] ) {
						if(Campusmap[l.x+dx[d]][l.y+dy[d]]=='X') continue;
						if(Campusmap[l.x+dx[d]][l.y+dy[d]]=='P') {
							cnt++;
							q.add(new Locate(l.x+dx[d],l.y+dy[d]));
							isVisited[l.x+dx[d]][l.y+dy[d]]=true;
						}
						if(Campusmap[l.x+dx[d]][l.y+dy[d]]=='O') {
							q.add(new Locate(l.x+dx[d],l.y+dy[d]));
							isVisited[l.x+dx[d]][l.y+dy[d]]=true;
						}
					}
				}
			}
		}
		if(cnt==0)
			System.out.println("TT");
		else
			System.out.println(cnt);
	}
}
