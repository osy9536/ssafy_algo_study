package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class b17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		Map<String, String> site = new HashMap<String, String>();
		
		for (int i = 0; i < n; i++) {
			String[] is = br.readLine().split(" ");
			site.put(is[0], is[1]);
		}
		for (int i = 0; i < m; i++) {
			String key = br.readLine();
			bw.write(site.get(key)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
