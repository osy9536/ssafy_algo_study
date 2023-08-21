package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5658 {
	static List<Integer> ansList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()) / 4;
			int K = Integer.parseInt(st.nextToken());
			char[] hexNumbers = br.readLine().toCharArray();
			
			ansList = new ArrayList<>();
			
			findMaxInCharArray(N, hexNumbers);
//			System.out.println();
			for (int i=1; i<N; i++) {
				int len = hexNumbers.length;
				char tmp = hexNumbers[len - 1];
				for (int j=len-2; j>=0; j--) hexNumbers[j+1] = hexNumbers[j];
				hexNumbers[0] = tmp;
				findMaxInCharArray(N, hexNumbers);
			}
			Collections.sort(ansList, Collections.reverseOrder());
//			System.out.println(ansList);
			sb.append("#").append(tc).append(" ").append(ansList.get(K-1)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void findMaxInCharArray(int N, char[] numbers) {
		int max = 0;
		for (int i=0; i<4; i++) {
			String number = "";
			char[] number2 = new char[N];
			for (int j=0; j<N; j++) {
				number += numbers[N*i+j];
				number2[j] = numbers[N*i+j];
			}
//			System.out.println(number);
			int decimal = hextodec(number.toCharArray());
//			System.out.println(decimal);
			if (!ansList.contains(decimal)) ansList.add(decimal);
		}
	}
	
	public static int hextodec(char[] n) {
		int len = n.length;
		int mul = 1;
		int ret = 0;
		for (int i=len-1; i>=0; i--) {
			int htod = 0;
			if (n[i] >= '0' && n[i] <= '9') ret += (n[i] - '0')*mul;
			else if (n[i] == 'A') ret += 10*mul;
			else if (n[i] == 'B') ret += 11*mul;
			else if (n[i] == 'C') ret += 12*mul;
			else if (n[i] == 'D') ret += 13*mul;
			else if (n[i] == 'E') ret += 14*mul;
			else if (n[i] == 'F') ret += 15*mul;
			mul *= 16;
		}
		return ret;
	}
}
