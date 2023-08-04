package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class b2422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Set<Integer>> ice = new ArrayList<Set<Integer>>();
		
		for (int i = 0; i <= n; i++) {
			ice.add(new HashSet<Integer>());
		}
		
		for (int i = 0; i < m; i++) { // 조합 안 되는 애들 서로 기록
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			ice.get(one).add(two);
			ice.get(two).add(one);
			
		}

		int result = 0;
		
		for (int i = 1; i <= n-2; i++) {
			for (int j = i+1; j <= n-1; j++) {
				if (ice.get(i).contains(j)) continue;
				for (int k = j+1; k <= n; k++ ) {
					if (ice.get(i).contains(k) || ice.get(j).contains(k)) continue;
					result++;
				}

			}
		}
		
		System.out.println(result);
	}
}
