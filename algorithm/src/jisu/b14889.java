package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b14889 {
	static int[][] power;
	static int n;
	static int ATEAM;
	static int mini = Integer.MAX_VALUE;
	
	public static void pick(List<Integer> member) {
		int pMem = member.size();
		if (pMem == ATEAM) {
			score(member);
			return;
		}
		for (int i = member.get(pMem-1) + 1; i <= n - (ATEAM - pMem); i++) {
			member.add(i);
			pick(member);
			member.remove(pMem);
		}
	}
	
	public static void score(List<Integer> member) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < power.length; j++) {
				if (member.contains(i) && member.contains(j)) a+=power[i][j];
				else if (!member.contains(i) && !member.contains(j)) b+=power[i][j];
			}
		}
		if (mini > Math.abs(a-b)) mini = Math.abs(a-b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		ATEAM = n/2;
		power = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<Integer> member = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			member.add(i);
			pick(member);
			member.remove(0);
		}
		
		System.out.println(mini);
	}
}

