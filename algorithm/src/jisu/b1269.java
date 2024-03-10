package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> c = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			a.add(num);
			c.add(num);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}
		
		a.removeAll(b);
		b.removeAll(c);
		
		System.out.println(a.size() + b.size());
		
	}

}
