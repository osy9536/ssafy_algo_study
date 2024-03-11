package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b22233 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), true);
        }
        int cnt = n;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (map.containsKey(s)) {
                    map.remove(s);
                    cnt--;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
    }
}
