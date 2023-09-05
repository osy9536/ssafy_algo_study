package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b15686 {
	static int N,M;
	static int[][] arr;
	static List<int[]> list;
	static int[] cmb;
	static boolean[] visited;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		list = new ArrayList<int[]>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 2) {
					list.add(new int[] {i,j});
					arr[i][j] = 0;
					cnt++;
				}
				else {
					arr[i][j] = a;
				}
			}
		}
//		System.out.println(cnt);
//		for (int[] a : list) {
//			System.out.println(a[0] + "  " +a[1]);
//		}
		cmb = new int[M];
		visited = new boolean[list.size()];
		res = Integer.MAX_VALUE;
		comb(0,0);	
		System.out.println(res);
	}
	private static void comb(int x,int cnt) {
		if(cnt == M) {
//			for (int i = 0; i < list.size(); i++) {
//			if(visited[i])System.out.print(i+" ");
//			}
//			System.out.println();
			calMin();
			return;
		} else {
			for (int i = x; i < list.size(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					comb(i + 1, cnt + 1);
					visited[i] = false;
				}
			}
		}
	}
	private static void calMin() {
		for (int i = 0; i < list.size(); i++) {
			if(visited[i]) {
				//System.out.print(i+" ");
				arr[list.get(i)[0]][list.get(i)[1]] = 2;
				int a = list.get(i)[0];
				int b = list.get(i)[1];
				//System.out.println("    " +a+"  "+b);
				
			}
		}
//		System.out.println();
//		print();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < N; j++) {
				int min = Integer.MAX_VALUE;
				if(arr[i][j] == 1) {
					
					for (int i2 = 0; i2 < N; i2++) {
						for (int j2 = 0; j2 < N; j2++) {
							if(arr[i2][j2] == 2) {
								int a = Math.abs(i2-i) + Math.abs(j2-j);
								min = Math.min(min, a);
							}
						}
					}
					sum += min;
				
				}
			}
		}
		res = Math.min(res, sum);
//		if(sum>res) {
//			res = sum;
//			print();
//		}
		//////////////////////////////////////////////////////
		for (int i = 0; i < list.size(); i++) {
			if(visited[i]) {
				arr[list.get(i)[0]][list.get(i)[1]] = 0;
			}
		}
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}



