package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b14232 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		List<Long> list = new ArrayList<>();
		
		while(n%2 == 0) {
			list.add((long) 2);
			n /= 2;
		}
		
		long d = 3;
		
		while(n > 1) {
			if (d >= 1000000) {
				list.add(n);
				break;
			}
			if (n%d == 0) {
				list.add(d);
				n /= d;
			} else {
				d += 2;
			}
		}
		
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
