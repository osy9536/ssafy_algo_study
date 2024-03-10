package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		
		int len = list.get(0).length();
		Set<String> set = new HashSet<>();
		for (int i = 1; i <= len; i++) {
			set.clear();
			for (int j = 0; j < n; j++) {
				set.add(list.get(j).substring(len - i));
			}
			if (set.size() == n) {
				System.out.println(i);
				break;
			}
		}
	}
}
