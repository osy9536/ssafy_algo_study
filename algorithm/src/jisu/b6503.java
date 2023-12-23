package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b6503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			String str = br.readLine();
			
			int result = n;
			
			int[] arr = new int[128];
			int right = -1;
			int left = -1;
			int cnt = 0;
			
			while (left <= right) {
				char c = str.charAt(right + 1);
				if (cnt < n || (cnt == n && arr[c] > 0 )) {
					right++;
					arr[str.charAt(right)]++;
					if (arr[str.charAt(right)] == 1) cnt++;
				} else {
					left++;
					arr[str.charAt(left)]--;
					if (arr[str.charAt(left)] == 0) {
						cnt--;
					}
				}
				if (result < right - left) result = right - left;
				if (right == str.length() - 1) break;
			}
			System.out.println(result);
		}
	}
}
