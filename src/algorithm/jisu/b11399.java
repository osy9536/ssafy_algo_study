package algorithm.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class b11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		List<Integer> time = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			time.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(time);
		int result = 0;
		for (int i = 0; i < n; i++) {
			int j = time.get(i);
			result += j * (n-i);
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}
