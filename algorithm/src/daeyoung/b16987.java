package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 16987
 * 계란으로 계란치기
 * 골드 5
 * https://www.acmicpc.net/problem/16987
 */
public class b16987 {
	
	static int n; //egg num
	static int[][] eggs;
	static int count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); 
		
		//durability weight
		eggs = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		counting(0, 0);
		
		System.out.println(count);
	}
	
	public static void counting(int index, int cnt) {
		if(index == n || cnt == n -1) {
			count= Math.max(cnt, count);
			return;
		}
		
		if(eggs[index][0] <= 0 ) {
			counting(index + 1, cnt);
			return;
		}
		
		int temp = cnt;
		for(int i = 0; i < n; i++) {
			if(i == index)
				continue;
			
			if(eggs[i][0] <= 0)
				continue;
			
			hit(index, i);
			
			if(eggs[i][0] <= 0)
				cnt++;
			
			if(eggs[index][0] <= 0)
				cnt++;
			
			counting(index + 1, cnt);
			
			recover(index, i);
			cnt = temp;
		}
	}
	
	public static void hit(int hand, int target) {
		eggs[hand][0] -= eggs[target][1];
		eggs[target][0] -= eggs[hand][1];
	}
	
	public static void recover(int hand, int target) {
		eggs[hand][0] += eggs[target][1];
		eggs[target][0] += eggs[hand][1];
	}
}
