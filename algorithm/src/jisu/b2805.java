package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2805 {
	public static int binarySearch(int s, int e, int m, int[] namu) {
		int p = -1;
		/*
		 * 우선 (s+e)/2 해서 완벽히 m이랑 같으면 p로 결정
		 * m보다 크면 s = p (이게 되는 제일 큰 수일 수 있으니)
		 * m보다 작으면 e = p-1 (작으면 아예 정답이 아님)
		 * s와 e가 1차이 일 때 s는 당연히 되고 e만 검증하면 됨
		 */
		
		int end = e;
		for (int i = s; i < end; i++) {
			if (s==e) return s;
			p = (s+e)/2;
			if (e-s == 1) p++;
			
			long result = 0;
			for (int j = 0; j < namu.length; j++) {
				int cha = namu[j] - p;
				if (cha > 0) result += cha;
			}
			if (result > m) s = p;
			else if (result < m) e = p-1;
			else return p;
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		/*
		 * 높이 h 정하면 한줄의 나무 싹 다
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] namu = new int[n];
		int maxi = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < namu.length; i++) {
			namu[i] = Integer.parseInt(st.nextToken());
			if (maxi < namu[i]) maxi = namu[i];
		}
		
		System.out.println(binarySearch(0, maxi-1, m, namu));
		
	}
}
