package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		String a = br.readLine();
		int cnt = 0;
		
		for (int i = 0; i <= str.length()-a.length(); i++) {
			if (str.substring(i, i+a.length()).equals(a)) {
				cnt++;
				i+=a.length()-1;
			}
		}
		
		System.out.println(cnt);
	}

}
