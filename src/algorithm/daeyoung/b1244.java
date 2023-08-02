package algorithm.daeyoung;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1244
 * 스위치 켜고 끄기
 * 실버 4
 * https://www.acmicpc.net/problem/1244
 */
public class b1244 {
	
	static int[] ss;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//스위치 개수
		int s = Integer.parseInt(st.nextToken());
		//스위치 상태
		ss = new int[s + 1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < s + 1; i++) {
			ss[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		//사람 수
		int p = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int kind = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(kind == 1) {
				manChange(n);
			}
			else {
				girlChange(n);
			}
				
		}
		
		for(int i = 1; i < s + 1; i++) {
			System.out.print(ss[i] + " ");
			if(i % 20 == 0)
				System.out.println();
		}
			
	}

	
	public static void manChange(int n) {
		for(int i = n; i < ss.length; i += n) {
			ss[i] = 1 - ss[i];
		}
	}
	
	public static void girlChange(int n) {
		int start = n - 1;
		int end = n + 1;
		
		ss[n] = 1 - ss[n];
		
		while(start > 0 && end < ss.length) {
			if(ss[start] != ss[end])
				break;
			
			ss[start] = 1 - ss[start];
			ss[end] = 1 - ss[end];
			start -= 1;
			end += 1;
		}
	}
	
}
