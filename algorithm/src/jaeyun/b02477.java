package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b02477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int multiplier = Integer.parseInt(br.readLine());
		int x = 0, y = 0;
		int[][] history = new int[6][4];
		for (int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int amt = Integer.parseInt(st.nextToken());
			if (dir == 1) y += amt;
			else if (dir == 2) y -= amt;
			else if (dir == 3) x += amt;
			else if (dir == 4) x -= amt;
			history[i] = new int[] {dir, amt};
		}
//		System.out.println(Arrays.deepToString(history));
		int big_x = 0, big_y = 0;
		for (int i=0; i<6; i++) {
			if ((history[i][0] == 1 || history[i][0] == 2) && history[i][1] > big_y) big_y = history[i][1];
			else if ((history[i][0] == 3 || history[i][0] == 4) && history[i][1] > big_x) big_x = history[i][1];
		}
		int little = 1;
		for (int i=0; i<6; i++) {
			int next = (i+1) % 6;
			int nnext = (i+2) % 6;
			if (history[i][0] == history[nnext][0]) little *= history[next][1];

		}
		System.out.println(multiplier*(big_x*big_y-little));
	}
}
