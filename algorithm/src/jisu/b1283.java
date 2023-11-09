package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1283 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int n = Integer.parseInt(br.readLine());
		Set<Character> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			String allStr = br.readLine();
			String[] str = allStr.split(" ");
			int where = -1;
			for (int j = 0; j < str.length; j++) {
				if (where != -1) break;
				char c = str[j].charAt(0);
				String s = c+"";
				if (!set.contains(c)) {
					if (Character.isUpperCase(c)) {
						set.add(s.toLowerCase().charAt(0));
					} else set.add(s.toUpperCase().charAt(0));
					set.add(c);
					where = 0;
					for (int k = 0; k < j; k++) {
						where += str[k].length();
						where++;
					}
					
				}
			}
			for (int j = 0; j < allStr.length(); j++) {
				if (where != -1) break;
				char c = allStr.charAt(j);
				if (c == ' ') continue;
				String s = c+"";
				if (!set.contains(c)) {
					if (Character.isUpperCase(c)) {
						set.add(s.toLowerCase().charAt(0));
					} else set.add(s.toUpperCase().charAt(0));
					set.add(c);
					where = j;
				}
				
				
			}
			
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < allStr.length(); j++) {
				if (j==where) sb.append('[');
				sb.append(allStr.charAt(j));
				if (j==where) sb.append(']');
			}
			System.out.println(sb.toString());
			
		}

	}

}
