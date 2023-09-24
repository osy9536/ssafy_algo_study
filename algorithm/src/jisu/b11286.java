package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (Math.abs(o1) == Math.abs(o2)) return o1-o2;
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				if (que.size() == 0) bw.write(0 + "\n");
				else bw.write(que.poll() + "\n");
			}
			else que.add(a);
		}
		bw.flush();
		bw.close();
	}
}
