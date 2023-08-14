package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16935
 * 배열 돌리기3
 * 골드 5
 * https://www.acmicpc.net/problem/16935
 */
public class b16935 {
	static int[][] a;
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		a = new int[n + 1][m + 1];
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < m + 1; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] cal = new int[r];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < r; i++)
			cal[i] = Integer.parseInt(st.nextToken());
		
		for(int i : cal) {
			if(i == 1)
				one();
			else if(i == 2)
				two();
			else if(i == 3)
				three();
			else if(i == 4)
				four();
			else if(i == 5)
				five();
			else if (i == 6)
				six();
		}
		
		printArray(a);
		
	}
	
	public static void one() {
		int[][] temp = new int[a.length][a[0].length];
		
		for(int j = 1; j < a[0].length; j++) {
			for(int i = 1; i < a.length; i++) {
				temp[i][j] = a[a.length- i][j];
			}
		}
		
		copyArray(temp);
		
	}
	
	public static void two() {
		int[][] temp = new int[a.length][a[0].length];
		
		for(int i = 1; i < a.length; i++) {
			for(int j = 1; j < a[0].length; j++)
				temp[i][j] = a[i][a[0].length - j];
		}
		
		copyArray(temp);
	}
	
	public static void three() {
		int[][] temp = new int[a[0].length][a.length];
		
		for(int j = 1 ; j < a[0].length; j++) {
			for(int i = a.length - 1; i > 0; i--) {
				temp[j][a.length - i] = a[i][j];
			}
		}
		
		copyArray(temp);
	}
	
	public static void four() {
		int[][] temp = new int[a[0].length][a.length];
		
		for(int j = 1 ; j < a.length; j++) {
			for(int i = a[0].length - 1; i > 0; i--) {
				temp[a[0].length - i][j] = a[j][i];
			}
		}
		
		copyArray(temp);
	}
	
	public static void five() {
		int[][] temp = new int[a.length][a[0].length];
		
		//1에서 2
		for(int i = 1; i <= (a.length - 1) / 2; i++) {
			for(int j = 1; j <= (a[0].length - 1) / 2; j++) {
				temp[i][j + (a[0].length - 1) /2] = a[i][j];
			}
		}
		
		//2에서3
		for(int i = 1; i <= (a.length - 1) / 2; i++) {
			for(int j = 1; j <= (a[0].length - 1) / 2; j++) {
				temp[i + (a.length - 1) / 2][j + (a[0].length - 1) /2] = a[i][j + (a[0].length - 1) /2];
			}
		}
		
		//3에서4
		for(int i = 1; i <= (a.length - 1) / 2; i++) {
			for(int j = 1; j <= (a[0].length - 1) / 2; j++) {
				temp[i + (a.length - 1) / 2][j] = a[i + (a.length - 1) / 2][j + (a[0].length - 1) /2];
			}
		}
		
		//4에서1
		for(int i = 1; i <= (a.length - 1) / 2; i++) {
			for(int j = 1; j <= (a[0].length - 1) / 2; j++) {
				temp[i][j] = a[i + (a.length - 1) / 2][j];
			}
		}
		
		copyArray(temp);
	}
	
	public static void six() {
		int[][] temp = new int[a.length][a[0].length];
		
		//1에서4
		for(int i = 1; i <= (a.length - 1) / 2; i++) {
			for(int j = 1; j <= (a[0].length - 1) / 2; j++) {
				temp[i + (a.length - 1) / 2][j] = a[i][j];
			}
		}
		
		//4에서3
		for(int i = 1; i <= (a.length - 1) / 2; i++) {
			for(int j = 1; j <= (a[0].length - 1) / 2; j++) {
				temp[i + (a.length - 1) / 2][j + (a[0].length - 1) /2] = a[i + (a.length - 1) / 2][j];
			}
		}
		
		//3에서2
		for(int i = 1; i <= (a.length - 1) / 2; i++) {
			for(int j = 1; j <= (a[0].length - 1) / 2; j++) {
				temp[i][j + (a[0].length - 1) / 2] = a[i + (a.length - 1) / 2][j + (a[0].length - 1) /2];
			}
		}
		
		//2에서1
		for(int i = 1; i <= (a.length - 1) / 2; i++) {
			for(int j = 1; j <= (a[0].length - 1) / 2; j++) {
				temp[i][j] = a[i][j + (a[0].length - 1) / 2];
			}
		}
		
		copyArray(temp);
	}
	
	public static void copyArray(int[][] temp) {
		a = new int[temp.length][temp[0].length];
		
		for(int i = 1; i < a.length; i++) {
			for(int j = 1;  j < a[i].length; j++) {
				a[i][j] = temp[i][j];
			}
		}
	}
	
	public static void printArray(int[][] temp) {
		for(int i = 1; i < temp.length; i++) {
			for(int j = 1; j < temp[i].length; j++)
				System.out.print(temp[i][j] + " ");
			System.out.println();
		}
	}
	
}
