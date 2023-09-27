package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2239 {
	
	static int[][] map = new int[9][9];
	static boolean complete;
	public static boolean findx(int x, int y, int n) {
		for(int i = 0 ; i < 9; i++) {
			if(map[x][i]==n || map[i][y]==n)
				return false;
		}
		return true;
	}
	public static boolean find(int x, int y, int n) {
		for(int i = (x/3)*3 ; i <((x/3)*3)+3 ; i++) {
			for(int j = (y/3)*3 ; j <((y/3)*3)+3 ; j++) {
				if(x==i && j==y) continue;
				if(map[i][j]==n)
					return false;
			}
		}
		return true;
	}
	public static void DFS(int x, int y) {
		if(x==9 && y==0) {
			for(int i = 0 ; i < 9 ; i ++) {
				for(int j = 0 ; j < 9 ; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(map[x][y]!=0) {
			if(y+1==9) {
				DFS(x+1,0);
				return;
			}
			else {
				DFS(x,y+1);
				return;
			}
		}
		
		else {
			for(int i = 1 ; i <= 9 ; i++) {
				if(findx(x,y,i) && find(x,y,i)) {
					map[x][y] = i;
					if(y+1==9) {
						DFS(x+1,0);
						map[x][y] = 0;
					}
					else {
						DFS(x,y+1);
						map[x][y] = 0;
					} 
				}
			}
		}
		return;
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < 9 ; i++) {
			String s = br.readLine();
			char[] str = new char[9];
			str=s.toCharArray();
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = str[j]-'0';
			}
		}
		DFS(0,0);
	}
	
}
/*
103000509
002109400
000704000
300502006
060000050
700803004
000401000
009205800
804000107
*/