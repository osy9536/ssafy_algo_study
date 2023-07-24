package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class b2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		Scanner sc = new Scanner(System.in);
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		
		ArrayList<Set> com = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			com.add(new HashSet() {});
		}
		
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
//			bw.write(a+" "+b+'\n');
			
			com.get(a).add(b);
			com.get(b).add(a);
			
		}
		
//		bw.write(com.toString()+"\n");
		
		Set<Integer> warm = new HashSet<Integer>();
		Queue<Integer> path = new LinkedList<Integer>();
		
		path.add(1);
		warm.add(1);
		
		while (path.size() != 0) {
			int now = path.poll();
			for (Iterator iterator = com.get(now).iterator(); iterator.hasNext();) {
				Integer nextwarm = (Integer) iterator.next();
				if (warm.contains(nextwarm)) continue;
				path.add(nextwarm);
				warm.add(nextwarm);
			}
		}
		
//		bw.write(warm.toString()+"\n");
		bw.write(warm.size()-1+"");
		bw.flush();
		bw.close();
		
		
	}
}
