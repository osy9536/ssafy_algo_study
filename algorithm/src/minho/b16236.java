package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loca{
	int x, y;
	public Loca(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class b16236{
	static boolean end=false ;
	static int[][] map;
	static Loca location;
	static int N,sharkSize=2, eaten=0, answer=0;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static boolean[][] isVisited; 
	static ArrayList<Loca> list;
	public static void BFS() { //최단거리 및 물고기위치
		Queue<Loca> q = new ArrayDeque<>();
		list = new ArrayList<>();
		q.add(location);
		isVisited= new boolean[N][N];
		isVisited[location.x][location.y] = true;
		int cnt=0;
		boolean flag = false;
		here : while(!q.isEmpty()) {
			int qsize = q.size();
			cnt++;
			for(int i = 0 ; i < qsize; i++) {
				Loca l = q.poll();
				for(int d = 0 ; d < 4 ; d++) {
					int ex = l.x+dx[d];
					int ey = l.y+dy[d];
					if(ex>=0 && ey>=0 && ey<N && ex<N && map[ex][ey]<=sharkSize
							&& !isVisited[ex][ey]) {
						if(map[ex][ey]<sharkSize && map[ex][ey]!=0) {  //최단거리 물고기 찾음
							list.add(new Loca(ex,ey));
							flag=true;
						}
						else { 	//경로찾음
							q.add(new Loca(ex,ey));
							isVisited[ex][ey]=true;
						}
					}
				}
			}
			if(flag) break here;
		}
		if(list.isEmpty())
			end= true;
		else {
			list.sort((o1,o2)->{
				if(o1.x==o2.x)
					return o1.y-o2.y;
				return o1.x-o2.x;
			});
			map[location.x][location.y]=0;
			location.x=list.get(0).x;
			location.y=list.get(0).y;
			map[location.x][location.y] = 400;
			answer+=cnt;
			return;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9)
					location=new Loca(i,j);
			}
		}
		while(true){
			BFS();
			if(end) break;
			eaten++;
			if(eaten==sharkSize) {
				eaten=0;
				sharkSize++;
			}
		}
		System.out.println(answer);
		
		//아기 상어 위치 
		//아기상어가 먹을 수 있는 물고기 위치 q.add()
		//최단거리 구하고
		//왼쪽에 있는거 선택하고
		//먹고 time++ 아기상어 위치 조정 먹은 물고기 cnt++  
		//if cnt==size  size++ 물고기위치 다시 q.add(); cnt=0;
		//q가 비면 종료
		
		
	}
}