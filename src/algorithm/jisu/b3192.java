package algorithm.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class b3192 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int[][] square = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> sum = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		
		int dagag = 0;
		int bagag = 0;
		count.add(0);
		count.add(0);
		sum.add(0);
		sum.add(0);
		
		for (int i = 0; i < square.length; i++) {
			int garo = 0;
			count.add(0);
			int sero = 0;
			count.add(0);
			for (int j = 0; j < square.length; j++) {
				garo += square[i][j];
				if (square[i][j] == 0) {
					int imsi = count.get(count.size()-2);
					count.set(count.size()-2, imsi+1);
				}
				sero += square[j][i];
				if (square[j][i] == 0) {
					int imsi = count.get(count.size()-1);
					count.set(count.size()-1, imsi+1);
				}
			}
			dagag += square[i][i];
			if (square[i][i] == 0) {
				int imsi = count.get(0);
				count.set(0, imsi+1);
			}
			
			bagag += square[i][2-i];
			if (square[i][2-i] == 0) {
				int imsi = count.get(1);
				count.set(1, imsi+1);
			}
			sum.add(garo);
			sum.add(sero);
		}
		sum.set(0, dagag);
		sum.set(1, bagag);
		
		
		
		int result = Collections.max(sum);
//		bw.write(result + " " + count.toString() + " " + sum.toString() + "\n");
		
		if (count.get(0) == 3 || count.get(1) == 3) {
			int thr = (sum.get(2)- sum.get(6) + sum.get(4)) / 2;
			int one = sum.get(4) - thr;
			int two = sum.get(2) - thr;
			
			square[1][1] = two;
			
			if (square[0][0] == 0) {
				square[0][0] = one;
				square[2][2] = thr;
			} else {
				square[0][2] = one;
				square[2][0] = thr;
			}
		} else {
			for (int i = 0; i < square.length; i++) {
				for (int j = 0; j < square.length; j++) {
					if (square[i][j] == 0) {
						int garo = i*2 + 2;
						int sero = j*2 + 3;

						if (count.get(garo) == 1) {
							square[i][j] = result - sum.get(garo);
						} else if (count.get(sero) == 1) {
							square[i][j] = result - sum.get(sero);
						} else if (count.get(0) == 1 && i == j) {
							square[i][j] = result - sum.get(0);
						} else if (count.get(1) == 1 && i == 2-j) {
							square[i][j] = result - sum.get(1);
						}
								
					}
				}
			}
		}
		
		
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				bw.write(square[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}