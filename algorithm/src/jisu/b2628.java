package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b2628 { 
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result = -1;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		Set<Integer> garo = new TreeSet<Integer>();
		Set<Integer> sero = new TreeSet<Integer>();
		
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int gs = Integer.parseInt(st.nextToken());
			if (gs == 0) garo.add(Integer.parseInt(st.nextToken()));
			else sero.add(Integer.parseInt(st.nextToken()));
		}
		garo.add(m);
		sero.add(n);
		
		int g = 0;
		int gmax = -1;
		int s = 0;
		int smax = -1;
		for (int i : garo) {
			int c = i-g;
			if (gmax < c) gmax = c;
			g = i;
		}
		for (int i : sero) {
			int c = i-s;
			if (smax < c) smax = c;
			s = i;
		}
		
		
		System.out.println(gmax*smax);
	}
}
