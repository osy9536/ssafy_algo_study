package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class b17144{
	
	static int[][] map, copy;
	static int count = 0, R, C, T, answer=0;
	static int[] dx = {-1,0,1,0}, xy;
	static int[] dy = {0,1,0,-1};
	static int[] dx1 = {1,0,-1,0};
	static int[] dy1 = {0,1,0,-1};
	
	private static void Diffusion() {
		copy = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++){
				if(map[i][j]!=-1 && map[i][j]!=0) {
					int ck = 0;
					for(int d = 0 ; d < 4 ; d++) {
						int xd=i+dx[d];
						int yd=j+dy[d];
						if(xd>=0 && xd<R && yd>=0 && yd<C && map[xd][yd]!=-1) {
							ck++;
							copy[xd][yd]+=map[i][j]/5;
						}
					}
					copy[i][j]+=map[i][j]-(ck*(map[i][j]/5));
				}
			}
		}
		copy[xy[0]][xy[1]]=-1;
		copy[xy[2]][xy[3]]=-1;
		for(int i = 0 ; i < R ; i++) {
			map[i] = copy[i].clone();
		}
	}
	
	private static void AirCleaner() {
		int AirX=xy[0]-1, AirY=xy[1],d=0;
		while(true) {
			if(AirX==xy[0] && AirY==xy[1]+1) break;
			int a = AirX+dx[d];
			int b = AirY+dy[d];
			if(a>=0 && b>=0 && a<=xy[0] && b<C) {
				map[AirX][AirY] = map[a][b];
				AirX=a;
				AirY=b;
			}
			else {
				d++;
				continue;
			}
		}
		
		d=0;
		AirX=xy[2]+1;
		AirY=xy[3];
		while(true) {
			if(AirX==xy[2] && AirY==xy[3]+1) break;
			int a = AirX+dx1[d];
			int b = AirY+dy1[d];
			if(a>=xy[2] && b>=0 && a<R && b<C) {
				map[AirX][AirY] = map[a][b];
				AirX=a;
				AirY=b;
			}
			else {
				d++;
				continue;
			}
		}
		map[xy[0]][xy[1]+1]=0;
		map[xy[2]][xy[3]+1]=0;
	}

	private static void Rutine() {
		if(T==count) {
			answer = 0;
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++){
					if(map[i][j]!=-1) {
						answer+=map[i][j];
					}
				}
			}
			System.out.println(answer);
			return;
		}
		Diffusion();
		AirCleaner();
		count++;
		Rutine();
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		xy = new int[4];
		int size =0;
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					xy[size++]=i;
					xy[size++]=j;
				}
			}
		}
		Rutine();
	}
}