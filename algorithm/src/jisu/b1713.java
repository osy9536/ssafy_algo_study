package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1713 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		
		TreeSet<Integer> set = new TreeSet<>();
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (map.get(o1[0]) == map.get(o2[0])) {
					return o2[1] - o1[1];
				}
				return map.get(o1[0]) - map.get(o2[0]);
			}
		};
		
		List<int[]> que = new ArrayList<>();


		for (int i = 0; i < m; i++) {
			int rec = Integer.parseInt(st.nextToken());

			if (map.containsKey(rec)) {
				map.replace(rec, map.get(rec) + 1);
			} else
				map.put(rec, 1);

			if (set.contains(rec)) {} 
			else if (que.size() < n) {
				que.add(new int[] {rec, 0});
				set.add(rec);
			}
			else {
				int[] temp = que.get(0);
				que.remove(0);
				set.remove(temp[0]);
				map.remove(temp[0]);
				que.add(new int[] {rec, 0});
				set.add(rec);
			}
			
			for (int j = 0; j < que.size(); j++) {
				que.get(j)[1]++;
			}
			
			Collections.sort(que, comp);
			
		}

		for (int i = 0; i < n; i++) {
			if (set.size() == 0) break;
			System.out.print(set.pollFirst() + " ");
		}
	}
}
