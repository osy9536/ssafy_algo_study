package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1270 {
	static int n, m;	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		Map<Long, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			map = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int half = cnt/2;
			String s = "SYJKGW";
			for (int j = 0; j < cnt; j++) {
				long a = Long.parseLong(st.nextToken());//Integer.parseInt(st.nextToken());
				if (map.containsKey(a)) map.replace(a, map.get(a)+1);
				else map.put(a, 1);
				if (map.get(a) > half) {
					s = "" + a;
					break;
				}
			}
			System.out.println(s);
		}
		
//		System.out.println(Integer.MAX_VALUE + " " +  Integer.MIN_VALUE);
		
	}
}
