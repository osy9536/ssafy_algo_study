package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2630{
	static int blue=0, white=0; // 0하얀색  ,,,  1 
	static int[][] paper;
	public static void re(int n , int x, int y, int color) {
		boolean check = true;
		for(int i = x ; i < x+n ; i++) {
			for(int j = y ; j <y+n ; j++) {
				if(color!=paper[i][j]) {
					check = false;
					break;
				}
			}
			if(!check) break;	
		}
		if(check==false) {
			re(n/2,x,y,paper[x][y]);
			re(n/2,x,y+(n/2),paper[x][y+(n/2)]);
			re(n/2,x+(n/2),y,paper[x+(n/2)][y]);
			re(n/2,x+(n/2),y+(n/2),paper[x+(n/2)][y+(n/2)]);
		}
		else {
			if(color==1) blue++;
			else white++;
		}
		return;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		re(N,0,0,paper[0][0]);
		System.out.println(white+" "+blue);
	}	
}



















