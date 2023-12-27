package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b7571 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		List<Integer> ylist = new ArrayList<>();
		List<Integer> xlist = new ArrayList<>();
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ylist.add(Integer.parseInt(st.nextToken()));
			xlist.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(ylist);
		Collections.sort(xlist);
		
		int y = ylist.get(n/2);
		int x = xlist.get(n/2);
		
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			answer += (Math.abs(ylist.get(i) - y));
			answer += (Math.abs(xlist.get(i) - x));
		}
		
		System.out.println(answer);
	}
}
