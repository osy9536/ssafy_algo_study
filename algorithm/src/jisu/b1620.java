package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class b1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> pocket = new HashMap<String, Integer>();
		HashMap<Integer, String> pocket2 = new HashMap<>();
		
		
		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			pocket.put(input, i);
			pocket2.put(i, input);
		}
		
		for (int i = 0; i < m; i++) {
			String check = br.readLine();
			
			if (49 <= check.charAt(0) && check.charAt(0) <= 57) {
				bw.write(pocket2.get(Integer.parseInt(check)) + "\n");
			} else {
				bw.write(pocket.get(check) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
