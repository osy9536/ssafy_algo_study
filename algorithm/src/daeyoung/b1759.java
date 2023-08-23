package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1759
 * 암호 만들기
 * 골드5
 * https://www.acmicpc.net/problem/1759
 */
public class b1759 {
	static String[] s;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		s = new String[c];
		visited = new boolean[c];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++)
			s[i] = st.nextToken();
		
		Arrays.sort(s);
		
		combi(0, 0, l, c);
	}
	
	public static void combi(int cur, int cnt, int l, int c) {
		if(cnt == l) {
			String secret = "";
			int gather = 0;
			
			for(int i = 0; i < c; i++) {
				if(visited[i]) {
					secret += s[i];
					if(s[i].equals("a") || s[i].equals("e") || 
							s[i].equals("i") || s[i].equals("o") || s[i].equals("u"))
						gather += 1;
				}
					
			}
			
			if(gather >= 1 && l - gather >= 2)
				System.out.println(secret);
			return;
		}
		
		for(int i = cur; i < c; i++) {
			visited[i] = true;
			combi(i + 1, cnt + 1, l, c);
			visited[i] = false;
		}
	}
}
