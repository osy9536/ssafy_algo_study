package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b01706 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int x=0; x<R; x++) {
			char[] tmp = br.readLine().toCharArray();
			for (int y=0; y<C; y++) {
				map[x][y] = tmp[y];
			}
		}
		
		ArrayList<String> answerList = new ArrayList<>();
		// left to right
		for (int x=0; x<R; x++) {
			String tmp = "";
			for (int y=0; y<C; y++) {
				if (map[x][y] != '#') {
					tmp += map[x][y];
				}
				else if (tmp.length() > 1) {
					answerList.add(tmp);
					tmp = "";
				}
				else {
					tmp = "";
				}
			}
			if (!tmp.equals("") && tmp.length() > 1) answerList.add(tmp);
		}
		// top to bottom
		for (int y=0; y<C; y++) {
			String tmp = "";
			for (int x=0; x<R; x++) {
				if (map[x][y] != '#') {
					tmp += map[x][y];
				}
				else if (tmp.length() > 1) {
					answerList.add(tmp);
					tmp = "";
				}
				else {
					tmp = "";
				}
			}
			if (!tmp.equals("") && tmp.length() > 1) answerList.add(tmp);
		}
//		System.out.println(answerList);
		Object[] answerArray = answerList.toArray();
		Arrays.sort(answerArray);
		System.out.println(answerArray[0]);
	}
}





