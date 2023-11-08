package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		
		int res = 0;
		
		StringTokenizer stst = new StringTokenizer(st.nextToken(),"+");
		while(stst.hasMoreTokens()) {
			res+=Integer.parseInt(stst.nextToken());
		}
		int sum;
		while(st.hasMoreTokens()) {
			sum = 0;
			stst = new StringTokenizer(st.nextToken(),"+");
			while(stst.hasMoreTokens()) {
				sum+=Integer.parseInt(stst.nextToken());
			}
			res -= sum;
		}
		System.out.println(res);
	}

}
