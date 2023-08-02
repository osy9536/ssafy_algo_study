package algorithm.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b1260 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		ArrayList<TreeSet> nodes = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			nodes.add(new TreeSet() {});
		}
		

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			nodes.get(p1).add(p2);
			nodes.get(p2).add(p1);
		}

		
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> que = new LinkedList<Integer>();
		Set<Integer> dv = new TreeSet<Integer>();
		List<Integer> fordfs = new ArrayList<>();
		Set<Integer> bv = new TreeSet<Integer>();
		List<Integer> forbfs = new ArrayList<>();
		
		stack.push(v);

		que.add(v);

		
		while (stack.size() != 0) {
			int sp = stack.pop();
			if (dv.contains(sp)) continue;
			fordfs.add(sp);
			dv.add(sp);
			
			for (Iterator iterator = nodes.get(sp).descendingIterator(); iterator.hasNext();) {
				Integer nextnode = (Integer) iterator.next();

				if (dv.contains(nextnode)) {
					continue;
				}
				
				stack.push(nextnode);
				
			}	
		}
		
		while (que.size() != 0) {
			int qp = que.poll();
			if (bv.contains(qp)) continue;
			forbfs.add(qp);
			bv.add(qp);
			for (Iterator iterator = nodes.get(qp).iterator(); iterator.hasNext();) {
				Integer nextnode = (Integer) iterator.next();
				if (bv.contains(nextnode)) {
					continue;
				}
				que.add(nextnode);
			}
		}
		
		for (int i = 0; i < fordfs.size(); i++) {
			bw.write(fordfs.get(i).toString()+' ');
		}
		
		bw.write('\n');
		
		for (int i = 0; i < forbfs.size(); i++) {
			bw.write(forbfs.get(i).toString()+' ');
		}
		
		bw.flush();
		bw.close();
		
	}
}
