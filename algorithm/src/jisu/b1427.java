package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] nums = new int[10];
		for (int i = 0; i < s.length(); i++) {
			nums[s.charAt(i)-'0']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < nums[i]; j++) {
				sb.append(i);
			}
		}
		
		System.out.println(sb.toString());
	}
}
