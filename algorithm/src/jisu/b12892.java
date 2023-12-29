package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b12892 { // 생일 선물!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {p, v});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		int j = 0;
		long answer = 0;
		long result = 0;
		for (int i = 0; i < n; i++) {
			while (j < n && list.get(j)[0] - list.get(i)[0] < d) {
				result += list.get(j)[1];
				j++;
			}
			answer = Math.max(answer, result);
			if (j == n) break;
			
			result -= list.get(i)[1];
		}
		
		System.out.println(answer);
	}
}
