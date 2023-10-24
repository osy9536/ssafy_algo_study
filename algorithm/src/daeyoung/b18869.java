package algorithm.src.daeyoung;
import java.io.*;
import java.util.*;

/*
 * 백준 18869
 * 멀티버스 2
 * 골드 5
 * https://www.acmicpc.net/problem/18869
 */
public class b18869 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken()); //우주 개수
		int n = Integer.parseInt(st.nextToken()); //행성 개수
		
		String[] space = new String[m];
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			List<int[]> l = new ArrayList<>();
			for(int j = 0; j < n; j++) {
				l.add(new int[] {Integer.parseInt(st.nextToken()), j});
			}
			Collections.sort(l, (l1, l2) -> {
				return l1[0] - l2[0];
				});
			StringBuilder s = new StringBuilder();
			s.append(l.get(0)[1]);
			for(int j = 1; j < l.size(); j++) {
				if(l.get(j-1)[0] > l.get(j)[0])
					s.append(">").append(l.get(j)[1]);
				else if(l.get(j-1)[0] == l.get(j)[0])
					s.append("=").append(l.get(j)[1]);
				else if(l.get(j-1)[0] < l.get(j)[0])
					s.append("<").append(l.get(j)[1]);
			}
				
			space[i] = s.toString();
		}
		
		int answer = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = i + 1; j < m; j++) {
				if(space[i].equals(space[j]))
					answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}
