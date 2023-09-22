package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b20529 {
	static String[] str;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			str = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean find = false;
			if (N >= 33) {
				System.out.println(0);
				continue;
			}
			for (int i = 0; i < N; i++) 
				str[i] = st.nextToken();
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k < N; k++) {
						int cnt = 0;
						for (int l = 0; l < 4; l++) {
							if (str[i].charAt(l) != str[j].charAt(l)) cnt++;
							if (str[j].charAt(l) != str[k].charAt(l)) cnt++;
							if (str[k].charAt(l) != str[i].charAt(l)) cnt++;
						}
						if(min>cnt) { 
							min =cnt;
							if(min==0) {
								System.out.println(0);
								find = true;
							}
						}
						if (find)
							break;
					}
					if (find)
						break;
				}
				if (find)
					break;
			}
			if (!find)
				System.out.println(min);
		}
	}
}
