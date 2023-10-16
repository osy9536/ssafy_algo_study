package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 20922
 * 겹치는 건 싫어
 * https://www.acmicpc.net/problem/20922
 */
public class b20922 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 총 원소 개수
		int k = Integer.parseInt(st.nextToken()); // 같은 원소 k개 이하
		
		int[] ary = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = 0;
		int[] count = new int[100001];
		int max = 0;
		
		count[ary[start]] += 1;
		
		while(end != n - 1) {
			
			if(end + 1 < n && count[ary[end + 1]] < k) {
				end += 1;
				count[ary[end]] += 1;
				max = Math.max(max, end - start + 1);
			} else if (start <= end) {
				count[ary[start]] -= 1;
				start += 1;
			}
			
		}
		
		System.out.println(max);
	}
}
