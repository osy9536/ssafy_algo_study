package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		
		bw.append("<");
		
		int last = 0;
		
		for (int i = 0; i < n; i++) {
			last = (last+k-1)%list.size();
			int next = list.get(last);
			list.remove(last);
			next++;
			bw.append(next+"");
			if (i!=n-1) bw.append(", ");
			else bw.append(">");
		}
		
		bw.flush();
		bw.close();
		
	}

}
