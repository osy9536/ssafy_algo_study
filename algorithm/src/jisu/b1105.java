package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1105 { 

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		String one = st.nextToken();
		String two = st.nextToken();
		
		int result = one.length();
		int cha = two.length() - one.length();
		
		if (cha == 0) {
			for (int i = 0; i < one.length(); i++) {
				char o = one.charAt(i);
				char t = two.charAt(i);
				if (o != t) {
					result -= (one.length() - i);
					break;
				} else if (o != '8') result--;
			}
		} else result = 0;
		
		System.out.println(result);
	}
}
