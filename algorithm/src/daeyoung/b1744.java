package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 1744
 * 수 묶기
 * 골드 4
 * https://www.acmicpc.net/problem/1744
 */
public class b1744 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		List<Integer> p = new ArrayList<>();
		List<Integer> m = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > 0)
				p.add(num);
			else
				m.add(num);
		}
		
		Collections.sort(p, Collections.reverseOrder());
		Collections.sort(m);
		
		int index = 0;
		long cur = 0;
		
		while(index < p.size()) {
			if(index + 1 >= p.size()) {
				cur += p.get(index);
				break;
			}
			
			int sum = p.get(index) + p.get(index + 1);
			int multi = p.get(index) * p.get(index + 1);
			
			if(sum >= multi) {
				cur += p.get(index);
				index += 1;
			} else {
				cur += multi;
				index += 2;
			}
		}
		
		index = 0;
		
		while(index < m.size()) {
			if(index + 1 >= m.size()) {
				cur += m.get(index);
				break;
			}
			
			int sum = m.get(index) + m.get(index + 1);
			int multi = m.get(index) * m.get(index + 1);
			
			if(sum >= multi) {
				cur += m.get(index);
				index += 1;
			} else {
				cur += multi;
				index += 2;
			}
		}
		
		System.out.println(cur);
		
	}

}
