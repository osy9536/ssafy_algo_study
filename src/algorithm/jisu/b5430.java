package algorithm.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			
			int n = Integer.parseInt(br.readLine());
			
			String origin_int = br.readLine();
			origin_int = origin_int.substring(1, origin_int.length()-1);
			
			st = new StringTokenizer(origin_int, ",");
			Deque<Integer> intarray = new LinkedList<>();
			for (int k = 0; k < n; k++) {
				intarray.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean error = false; 
			boolean reverse = false;
			
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'R') {
					reverse = reverse ^ true;
				} else {
					if (intarray.size() == 0) {
						error = true;
						break;
					} else if (reverse) {
						intarray.pollLast();
					} else {
						intarray.poll();
					}
				}
			}
			
			if (error) {
				bw.write("error");
			} else {
				bw.write("[");
				int ias = intarray.size();
				for (int j = 0; j < ias; j++) {
					if (reverse) bw.write(intarray.pollLast()+"");
					else bw.write(intarray.poll()+"");
					if (j!=ias-1) bw.write(",");
				}
				bw.write("]");
			}
			bw.write("\n");
			
		}
		
		bw.flush();
		bw.close();
	}
}
