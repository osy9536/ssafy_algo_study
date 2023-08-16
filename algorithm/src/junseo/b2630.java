package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2630_색종이 {

	static StringBuilder sb;
	static int N;
	static int[][] arr;
	static int[] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//print();
		res  = new int[2];
		sol(0,0,N);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	private static void sol(int x,int y,int n) {
		if(isPosible(x,y,n)) {
			res[arr[x][y]]++;
			return;
		}
		int size = n/2;
		
		sol(x,y,size);
		sol(x,y+size,size);
		sol(x+size,y,size);
		sol(x+size,y+size,size);

	}
	
	private static boolean isPosible(int x, int y, int size) {
		// TODO Auto-generated method stub
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

