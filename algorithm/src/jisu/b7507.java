package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b7507 {
	
	static class Play implements Comparable<Play> {
		
		int day, start, end;
		
		public Play(int day, int start, int end) {
			this.day = day;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Play o) {
			if (this.day == o.day) {
				if (this.end == o.end) return this.start - o.start;
				else return this.end - o.end;
			}
			return this.day - o.day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int P = Integer.parseInt(br.readLine());
			
			List<Play> list = new ArrayList<>();
			
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int d = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				list.add(new Play(d,s,e));
			}
			
			Collections.sort(list);
			
			int cnt = 0;
			int endDay = 0;
			int endTime = 0;
			
			for (Play p : list) {
				if (endDay < p.day || (endDay == p.day && endTime <= p.start) ) {
					cnt++;
					endDay = p.day;
					endTime = p.end;
				}
			}
			
			bw.write("Scenario #" + tc + ":\n");
			bw.write(cnt + "\n\n");
		}
		
		bw.flush();
		bw.close();
	}
}
