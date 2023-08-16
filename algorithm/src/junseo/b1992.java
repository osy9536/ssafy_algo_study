package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1992_쿼드트리 {
	
	static int N;
	static int[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j)- '0';
			}
		}
		
		sol(0,0,N);
		//print();
		System.out.println(sb);
	}
	
	private static void sol(int x, int y, int n) {
		if(isPossible(x,y,n)) {
			sb.append(arr[x][y]);
			return;
		}
		
		int size = n/2;
		sb.append("(");
		sol(x,y,size);
		sol(x,y+size,size);
		sol(x+size,y,size);
		sol(x+size,y+size,size);
		sb.append(")");
	}
	private static boolean isPossible(int x,int y,int size) {
		int value = arr[x][y];
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(value != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}


