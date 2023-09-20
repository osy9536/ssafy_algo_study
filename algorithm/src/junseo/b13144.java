package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cnt = new int[100001];		
		long res = 0;
		
		int end = 0;
		int start = 0;
		while (end < N) {
			int num = arr[end];
			cnt[num]++;
			end++;
			while(cnt[num]>1) {
				cnt[arr[start]]--;
				start++;
			}		
			res += end-start;

		}

		System.out.println(res);

	}

}


