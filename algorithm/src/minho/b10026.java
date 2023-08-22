package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10026 {
	static int N,countA=0,countB=0;
	static char[][] A,B;
	public static void find(int x,int y,char color) {
		if(A[x][y]!=color) return;
		A[x][y]='X';
		if(x+1<N)
			find(x+1,y,color);
		if(x-1>=0)
			find(x-1,y,color);
		if(y+1<N)
			find(x,y+1,color);
		if(y-1>=0)
			find(x,y-1,color);
		return;
	}
	public static void find2(int x,int y,char color) {
		if(color=='B' && (B[x][y]=='G' ||B[x][y]=='R' || B[x][y]=='X' )) return;
		if(color=='G' && (B[x][y]=='B' || B[x][y]=='X')) return;
		if(color=='R' && (B[x][y]=='B' || B[x][y]=='X')) return;
		B[x][y]='X';
		if(x+1<N)
			find2(x+1,y,color);
		if(x-1>=0)
			find2(x-1,y,color);
		if(y+1<N)
			find2(x,y+1,color);
		if(y-1>=0)
			find2(x,y-1,color);
		
		return;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new char[N][N];
		B = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			A[i]=s.toCharArray();
			B[i]=s.toCharArray();
		}
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j++) {
				if(A[i][j]!='X') {
					find(i,j,A[i][j]);
					countA++;
				}
				if(B[i][j]!='X') {
					countB++;
					find2(i,j,B[i][j]);
				}
			}
		}
		System.out.println(countA+" "+countB+"\n");
	}
}