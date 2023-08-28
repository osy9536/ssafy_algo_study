package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1043 {
	static List<List<Integer>> party;
	static int n;
	static int m;
	static int k;
	static List<Integer> know;
	static int maxi = Integer.MIN_VALUE;
	
	public static void pick(int p, int cnt, List<Integer> jinsil, List<Integer> guzit) {
		if (p==m) {
			if (maxi < cnt) maxi = cnt;
			return;
		}
		
		boolean jin = false;
		boolean gu = false;
		for (int i : party.get(p)) {
			if (jinsil.contains(i)) {
				if (gu) return;
				jin = true;
			} else if (guzit.contains(i)) {
				if (jin) return;
				gu = true;
			}
		}
		
		if (!jin) { // 거짓말 해도 된다
			List<Integer> newguzit = new ArrayList<Integer>();
			newguzit.addAll(guzit);
			for (int i : party.get(p)) {
				if (!guzit.contains(i)) newguzit.add(i);
			}
			pick(p+1, cnt+1, jinsil, newguzit);
		}
		if (!gu) { // 참말 해도 된다
			List<Integer> newjinsil = new ArrayList<Integer>();
			newjinsil.addAll(jinsil);
			for (int i : party.get(p)) {
				if (!jinsil.contains(i)) newjinsil.add(i);
			}
			pick(p+1, cnt, newjinsil, guzit);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		know = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			know.add(Integer.parseInt(st.nextToken()));
		}
		
		party = new ArrayList<List<Integer>>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			party.add(new ArrayList<Integer>());
			st.nextToken();
			for (int j = 0; j < n; j++) {
				try {
					int a = Integer.parseInt(st.nextToken());
					party.get(i).add(a);
				} catch (Exception e) {break;}
				
			}
		}
		
		List<Integer> jinsil = new ArrayList<Integer>();
		try {jinsil.addAll(know);}
		catch (Exception e) {}
		List<Integer> guzit = new ArrayList<Integer>();
		
		pick(0, 0, jinsil, guzit);
		
		
		System.out.println(maxi);
	}
}
