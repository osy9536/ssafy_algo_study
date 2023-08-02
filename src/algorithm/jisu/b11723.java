package algorithm.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class b11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		Set<Integer> s = new HashSet();
		Set<Integer> alls = new HashSet();
		
		for (int i = 1; i <= 20; i++) {
			alls.add(i);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String inst = st.nextToken();
			
			if (inst.equals("all")) {
				s.clear();
				s.addAll(alls);
			} else if (inst.equals("empty")) {
				s.clear();
			} else {
				int n = Integer.parseInt(st.nextToken());
				if (inst.equals("add")) {
					s.add(n);
				} else if (inst.equals("remove") && s.contains(n)) {
					s.remove(n);
				} else if (inst.equals("check")) {
					if (s.contains(n)) bw.write("1\n");
					else bw.write("0\n");
				} else if (inst.equals("toggle")) {
					if (s.contains(n)) s.remove(n);
					else s.add(n);
				}
			}
			
			
		}
		bw.flush();
		bw.close();
	}
}
