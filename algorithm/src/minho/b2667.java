package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//단지번호 붙이기 2667
public class b2667{
	static int cnt , ck, N, total=0;
	static char[][] map;
	static int[] answer = new int[325];//맥스 
	//한동에 몇개칸인지 확인함수 0 1  2 3 
	static int[] dirx = {0,-1,0,1}; 
	static int[] diry = {-1,0,1,0}; 
	public static void f(int x, int y) {
		map[x][y]='0'; //체크
		cnt++;
		// if 기저조건
		for(int i = 0 ; i < 4; i++) {
			if(x+dirx[i] >= 0 && x+dirx[i] <N && y+diry[i] >= 0 && y+diry[i] <N) {
				if(map[x+dirx[i]][y+diry[i]]=='1'){ 
					f(x+dirx[i],y+diry[i]);
					ck++;
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str;
		map= new char[N][N];
		for(int i = 0 ; i < N;i++) {
			str=br.readLine();
			map[i] = str.toCharArray();
		}
		
		for(int i = 0 ; i < N;i++) {
			for(int j = 0 ; j < N;j++) {
				if(map[i][j]=='1')	{
					cnt=0;
					f(i,j);
					answer[total] = cnt;
					total ++;
				}
			}
		}
		System.out.println(total);
		Arrays.sort(answer,0,total);
		for(int i = 0 ; i < total;i++) {
			System.out.println(answer[i]);
		}
	}
}