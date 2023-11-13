package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = Integer.parseInt(br.readLine());

		int MAX = 2_000_000;

		boolean[] vis;
		vis = new boolean[MAX + 1];

		int sqrt = (int) Math.sqrt(MAX);

		for (int i = 2; i <= sqrt; i++) {
			if (!vis[i]) {
				for (int j = i + i; j <= MAX; j = j + i) {
					vis[j] = true;
				}
			}
		}
		// -----------------소수 구하기 끝-----------------------------
		vis[1] = true;
		int ans = 0;
		for (int i = N; i <= MAX; i++) {
			if (!vis[i]) {
				String number = String.valueOf(i);
				char[] arr = number.toCharArray();
				if (palin(0, arr.length - 1, arr)) {
					ans = i;
					break;
				}
			}
		}
		System.out.println(ans);

	}

	private static boolean palin(int start, int end, char[] arr) {
		while(start < end) {
			if(arr[start] != arr[end])
				return false;
			start++;
			end--;
		}
		return true;
	}

}

