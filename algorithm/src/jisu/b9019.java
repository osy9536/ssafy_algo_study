package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class b9019 {
	public static int D(int n) {
		return (n*2) % 10000;
	}
	public static int S(int n) {
		return (n-1 + 10000) % 10000;
	}
	
	public static int L(int n) {
		return n % 1000 * 10 + n / 1000;
	}
	
	public static int R(int n) {
		return n / 10 + n % 10 * 1000;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			Queue<Integer> numque = new LinkedList<Integer>();
			Queue<String> dslrque = new LinkedList<>();
			Set<Integer> visit = new HashSet<>();
			
			numque.add(a);
			dslrque.add("");
			visit.add(a);
			
			String result = "";
			
			
			while (!numque.isEmpty()) {
				int num = numque.poll();
				String inst = dslrque.poll();
				if (num == b) {
					result = inst;
					break;
				}
				
				int d = D(num);
				if (!visit.contains(d)) {
					numque.add(d);
					dslrque.add(inst + "D");
					visit.add(d);
				}
				
				int s = S(num);
				if (!visit.contains(s)) {
					numque.add(s);
					dslrque.add(inst + "S");
					visit.add(s);
				}
				
				int l = L(num);
				if (!visit.contains(l)) {
					numque.add(l);
					dslrque.add(inst + "L");
					visit.add(l);
				}
				
				int r = R(num);
				if (!visit.contains(r)) {
					numque.add(r);
					dslrque.add(inst + "R");
					visit.add(r);
				}
			}
			
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
