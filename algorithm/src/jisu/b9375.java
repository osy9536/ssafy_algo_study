package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class b9375 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Set<String> wear = new HashSet<String>();
			List<String> cate = new ArrayList<String>();
			List<Integer> num = new ArrayList<Integer>();
			// 해쉬셋같은데다가 두번째값(의상종류)만 받고 있으면 카운트 1만, 없으면 카운트+1 과 셋에 추가
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String newone = st.nextToken();
				if (!wear.contains(newone)) {
					wear.add(newone);
					cate.add(newone);
					num.add(1);
				} else {
					int idx = cate.indexOf(newone);
					num.set(idx, num.get(idx)+1);
				}
				
			}
			
			int result = 1;
			
			for (int j = 0; j < num.size(); j++) {
				result *= (num.get(j) + 1);
			}
			
			bw.write(result - 1 + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
