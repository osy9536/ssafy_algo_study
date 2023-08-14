package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class b25758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> geneSet = new HashSet<>();
		Set<String> dupSet = new HashSet<>();
		for (int i=0; i<N; i++) {
			String nextToken = st.nextToken();
			if (geneSet.contains(nextToken)) {
				dupSet.add(nextToken);
			}
			else {
				geneSet.add(nextToken);
			}
		}
		List<String> geneList = new ArrayList<>();
		String[] geneSetArr = geneSet.toArray(new String[geneSet.size()]);
		String[] dupSetArr = dupSet.toArray(new String[dupSet.size()]);
		for (int i=0; i<geneSetArr.length; i++) geneList.add(geneSetArr[i]);
		for (int i=0; i<dupSetArr.length; i++) geneList.add(dupSetArr[i]);
//      System.out.println(geneList);
		
		Set<Character> ansSet = new HashSet<>();
		for (int i=0; i<geneList.size(); i++) {
			char c1 = geneList.get(i).toCharArray()[0];
			char c2 = geneList.get(i).toCharArray()[1];
			for (int j=i+1; j<geneList.size(); j++) {
				ansSet.add(c1 > geneList.get(j).toCharArray()[1] ? c1 : geneList.get(j).toCharArray()[1]);
				ansSet.add(c2 > geneList.get(j).toCharArray()[0] ? c2 : geneList.get(j).toCharArray()[0]);
			}
		}
		
		System.out.println(ansSet.size());
		Character[] ansArr = ansSet.toArray(new Character[ansSet.size()]);
		Arrays.sort(ansArr);
		for (char e: ansArr) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
}
