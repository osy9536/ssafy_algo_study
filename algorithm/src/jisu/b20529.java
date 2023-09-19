package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b20529 {
	static int result;
	
	static int chai(String w, String v) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (w.charAt(i) != v.charAt(i)) cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("INTP", 0);
		map.put("INFP", 1);
		map.put("INFJ", 2);
		map.put("ISFJ", 3);
		map.put("ESFJ", 4);
		map.put("ESFP", 5);
		map.put("ESTP", 6);
		map.put("ENTP", 7);
		map.put("ENTJ", 8);
		map.put("ENFJ", 9);
		map.put("ENFP", 10);
		map.put("ESTJ", 11);
		map.put("ISTJ", 12);
		map.put("INTJ", 13);
		map.put("ISTP", 14);
		map.put("ISFP", 15);
		
		Map<Integer, String> pair = new HashMap<>();
		pair.put(0, "INTP");
		pair.put(1, "INFP");
		pair.put(2, "INFJ");
		pair.put(3, "ISFJ");
		pair.put(4, "ESFJ");
		pair.put(5, "ESFP");
		pair.put(6, "ESTP");
		pair.put(7, "ENTP");
		pair.put(8, "ENTJ");
		pair.put(9, "ENFJ");
		pair.put(10, "ENFP");
		pair.put(11, "ESTJ");
		pair.put(12, "ISTJ");
		pair.put(13, "INTJ");
		pair.put(14, "ISTP");
		pair.put(15, "ISFP");
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] mbti = new int[16]; 
			for (int i = 0; i < n; i++) {
				mbti[map.get(st.nextToken())]++;
			}
			
			result = Integer.MAX_VALUE;
			
			for (int i = 0; i < mbti.length; i++) {
				if (mbti[i] >= 3) {
					result = 0;
					break;
				} 
			}
			
			for (int i = 0; i < mbti.length; i++) {
				for (int j = i; j < mbti.length; j++) {
					for (int k = j; k < mbti.length; k++) {
						int one = mbti[i];
						int two = mbti[j];
						int thr = mbti[k];
						if (one == 0 || two == 0 || thr == 0) continue;
						if (i == j) {
							if (j == k) {
								if (one < 3) continue;
							}
							if (one < 2) continue;
						} else if (j == k && two < 2) continue;
						
						String os = pair.get(i);
						String ws = pair.get(j);
						String rs = pair.get(k);
						
						int ans = chai(os, ws) + chai(os, rs) + chai(ws, rs);
						if (result > ans) result = ans;
					}
				}
			}
			
			System.out.println(result);
		}
	}
}
