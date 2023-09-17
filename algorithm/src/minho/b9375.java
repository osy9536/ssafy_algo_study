package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class C {
	String s;
	int cnt;

	public C(String s, int cnt) {
		super();
		this.s = s;
		this.cnt = cnt;
	}
}

public class b9375 {

	static int tc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<C> list = new ArrayList<>();
		int n;
		tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(br.readLine());
			if (n != 0) {
				for (int i = 0; i < n; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					st.nextToken();
					String s2 = st.nextToken();
					boolean ck = false;
					if (list.size() == 0)
						list.add(new C(s2, 1));
					else {
						for (int j = 0; j < list.size(); j++) {
							if (list.get(j).s.equals(s2)) {
								list.get(j).cnt += 1;
								ck = true;
							}
						}
						if (!ck)
							list.add(new C(s2, 1));
					}
				}
				int answer = list.get(0).cnt + 1;
				for (int j = 1; j < list.size(); j++) {
					answer *= list.get(j).cnt + 1;
				}
				System.out.println(answer - 1);
			} else
				System.out.println(0);
			list.clear();
		}
	}
}
