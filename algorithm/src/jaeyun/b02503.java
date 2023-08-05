package algorithm.src.jaeyun;

import java.io.*;
import java.util.*;

public class b02503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] questions = new int[N][3];
		StringTokenizer st;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			questions[i][0] = Integer.parseInt(st.nextToken());
			questions[i][1] = Integer.parseInt(st.nextToken());
			questions[i][2] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for (int i=123; i<=987; i++) {
			int i2 = i / 100;
			int i1 = (i % 100) / 10;
			int i0 = i % 10;
			if (i2 == i1 || i2 == i0 || i1 == i0 || i0 == 0) continue;
			System.out.println(i+" "+i2+i1+i0);
			boolean possible = true;
			for (int j=0; j<N; j++) {
				if (!isCorrect(i, questions[j][0], questions[j][1], questions[j][2])) {
					possible = false;
					break;
				}
			}
			if (possible) ans += 1;
		}
		
		System.out.println(ans);
	}
	public static boolean isCorrect(int target, int input, int strike, int ball) {
		int[] targetArr = new int[3];  // 324
		int[] inputArr = new int[3];   // 123
//		System.out.print(target+" "+input+" ");
		targetArr[0] = target / 100; target %= 100;
		inputArr[0] = input / 100; input %= 100;
		targetArr[1] = target / 10; target %= 10;
		inputArr[1] = input / 10; input %= 10;
		targetArr[2] = target;
		inputArr[2] = input;
		int nstrike = 0, nball = 0;    // ==> 1 strike, 1 ball
		for (int i=0; i<3; i++) {
			if (targetArr[i] == inputArr[i]) {
				nstrike += 1;
				targetArr[i] = inputArr[i] = 0;
			}
		}
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (targetArr[i] > 0 && inputArr[j] > 0 && targetArr[i] == inputArr[j]) {
					nball += 1;
				}
			}
		}
//		System.out.println(nstrike+" "+nball);
		if (nstrike == strike && nball == ball) {
//			System.out.println("yes");
			return true;
		}
//		System.out.println();
		return false;
	}
}
