package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

/**
 * 백준 6566
 * 애너그램 그룹
 * 실버1
 * https://www.acmicpc.net/problem/6566
 */
public class b6566 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String cur = "";
		
		Map<String, String> dic = new HashMap<>();
		
		while((cur = br.readLine()) != null) {

			char[] temp = cur.toCharArray();
			
			Arrays.sort(temp);
			
			String key = new String(temp);
			
			if(dic.containsKey(key)) {
				dic.put(key, dic.get(key) + " " + cur);
			} else {
				dic.put(key, cur);
			}
				
		}
		
		List<String> list = new ArrayList<>(dic.values());
		
		Collections.sort(list, (o1, o2) -> {
			String[] temp1 = o1.split(" ");
			String[] temp2 = o2.split(" ");
			
			if(temp1.length == temp2.length) {
				Arrays.sort(temp1);
				Arrays.sort(temp2);
				
				String temp11 = "";
				for(String s : temp1)
					temp11 += s;
				
				String temp22 = "";
				for(String s : temp2)
					temp22 += s;
		
				return temp11.compareTo(temp22);
			}
			return temp2.length - temp1.length;
		});
			
		int size = list.size();
		
		for(int i = 0; i < size; i++) {
			String[] temp = list.get(i).split(" ");
			Arrays.sort(temp);
			
			sb.append("Group of size ").append(temp.length).append(": ");
			for(int j = 0; j < temp.length; j++) {
				if(j != 0 && temp[j - 1].equals(temp[j]))
					continue;
				sb.append(temp[j]).append(" ");
			}
				
					
					
			
			sb.append(".").append("\n");
			if(i == 4)
				break;
		}
			
		System.out.println(sb);
		
	}
}
