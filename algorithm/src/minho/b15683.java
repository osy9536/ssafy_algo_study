package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class CCTV{
	int x,y,kind;
	public CCTV(int x, int y, int kind) {
		super();
		this.x = x;
		this.y = y;
		this.kind = kind;
	}
}
public class b15683{
	static int N,M,x,y,ans=0; // x,y
	static int[][] Map;
	static int[][] CopyMap;
	static List<CCTV> cctv;
	static int[] per;
	static int Min = Integer.MAX_VALUE;
	static int[][] d = {{0,-1},{-1,0},{0,1},{1,0}};
	public static void reset(int i){
		x=cctv.get(i).x;
		y=cctv.get(i).y;
	}
	public static void straight(int p,int i) {
		reset(i);
		while(x+d[p][0]>=0 && x+d[p][0]<N && y+d[p][1]>=0 && y+d[p][1]<M) {
			x+=d[p][0];
			y+=d[p][1];
			if(CopyMap[x][y]==6) break;
			else if(CopyMap[x][y]==0) CopyMap[x][y]=9;
		}
	}
	public static void toDo() {
		
		for(int i = 0 ; i < cctv.size() ;i ++) {
			if(cctv.get(i).kind==1) {
				straight(per[i],i);
			}
			if(cctv.get(i).kind==2) {
				straight(per[i],i);
				straight((per[i]+2)%4,i);
			}
			if(cctv.get(i).kind==3) {
				straight(per[i],i);
				straight((per[i]+1)%4,i);
			}
			if(cctv.get(i).kind==4) {
				straight(per[i],i);
				straight((per[i]+1)%4,i);
				straight((per[i]+2)%4,i);
			}
			if(cctv.get(i).kind==5) {
				straight(per[i],i);
				straight((per[i]+1)%4,i);
				straight((per[i]+2)%4,i);
				straight((per[i]+3)%4,i);
			}
		}
	}
	public static void permutation(int cnt) {
		if(cctv.size()==cnt) { // 중복순열 완성
			for(int i = 0 ; i < N ; i++) {
				CopyMap[i] = Map[i].clone();
			}
			toDo();
			findMax();
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {
			per[cnt]=i;
			permutation(cnt+1);
		}
	}
	public static void findMax() {
		int count =0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if( CopyMap[i][j]==0) { 
					count++;
				}
			}
		}
		Min = Math.min(Min,count);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		CopyMap = new int[N][M];
		cctv = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				Map[i][j] = Integer.parseInt(str.nextToken());
				if(Map[i][j]!=0 && Map[i][j]!=6) { //빈공간이거나 벽이 아닐때
					cctv.add(new CCTV(i,j,Map[i][j]));
				}
			}
		}
		per = new int[cctv.size()];
		permutation(0);
		System.out.println(Min);
	}	
}