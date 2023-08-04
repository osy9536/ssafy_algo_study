package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class b1389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	
		List<List<Integer>> kebin = new ArrayList<>(); // 바로 갈 수 있는
		List<int []> bacon = new ArrayList<>(); // 개인이 거기로 가는 데 얼마나 걸리는지
	
		for (int i = 0; i <= n; i++) {
			kebin.add(new ArrayList<> ());
			bacon.add(new int[n+1]);
		}
	
		int[] result = new int[n+1];
	
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			kebin.get(one).add(two);
			kebin.get(two).add(one);
		}
		
		
//		System.out.println(kebin.toString());
	
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (bacon.get(i)[j] == 0) {
					// 찾아놓은 값이 없으면 bfs 돌려서 빨리 찾아지는 값으로
					Queue<Integer> que = new LinkedList<Integer>();
					Queue<Integer> visit = new LinkedList<Integer>();
					Set<Integer> vnodes = new HashSet<Integer>();
					
					for (int k = 0; k < kebin.get(i).size(); k++) {
						que.add(kebin.get(i).get(k));
						visit.add(1);
					}
	
					while (!que.isEmpty()) {
						int now = que.poll();
						int v = visit.poll();
						if (now == j) {
							bacon.get(i)[j] = v;
							bacon.get(j)[i] = v;
							break;
						}
						for (int k = 0; k < kebin.get(now).size(); k++) {
							if (vnodes.contains(kebin.get(now).get(k))) continue;
							que.add(kebin.get(now).get(k));
							visit.add(v+1);
							vnodes.add(kebin.get(now).get(k));
						}
					}
	
				}
			}
		}
		
		int mini = Arrays.stream(bacon.get(1)).sum();
		int miniPerson = 1;
		for (int i = 2; i <= n; i++) {
			int sumPerson = Arrays.stream(bacon.get(i)).sum();
			if (mini > sumPerson) {
				mini = sumPerson;
				miniPerson = i;
			}
		}
		
		bw.write(miniPerson+"");
		bw.flush();
		bw.close();
	}

}