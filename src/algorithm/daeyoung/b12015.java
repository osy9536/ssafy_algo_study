package algorithm.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;

/**
 * 백준 12015
 * 가장 긴 증가하는 부분 수열2
 * 골드2
 * https://www.acmicpc.net/problem/12015
 */
public class b12015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] ary = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		
		List<Integer> lis = new ArrayList<>();
		 
		lis.add(ary[0]);
		for(int i = 1; i < n; i++) {
			if(lis.get(lis.size() - 1) < ary[i])
				lis.add(ary[i]);
			else {
				int start = 0;
				int end = lis.size() - 1;
				
				//이분 탐색
				while(start < end) {
					int mid = (start + end) / 2;
					
					if(ary[i] <= lis.get(mid)) {
						end = mid;
					} else if(ary[i] > lis.get(mid)) {
						start = mid + 1;
					} 
				}
				//값이 같지 않다면 대치
				if(lis.get(start) != ary[i])
					lis.set(start, ary[i]);
			}
		}
		
		System.out.println(lis.size());
	}
}
