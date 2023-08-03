package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class b1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		int result = 0;
		String num = "";
		Set<Character> plma = new HashSet<>();
		plma.add('+');
		plma.add('-');
		boolean canminus = false;
		
		for (int i = 0; i < s.length(); i++) {
			if (plma.contains(s.charAt(i)) || i == s.length()-1) {
				if (i == s.length()-1) num += s.charAt(i);
				int pNum = Integer.parseInt(num);
				num = "";
				if (canminus) result -= pNum;
				else result += pNum;
				if (s.charAt(i) == '-') canminus = true;
				
			} else {
				num += s.charAt(i);
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}
