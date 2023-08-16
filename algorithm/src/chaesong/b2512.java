import java.util.Scanner;

public class b2512 {
	static long arr[];
	static int N;
	static long M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new long[N]; long max = 0;
		for(int i = 0; i < N; i++) {
			long now = sc.nextLong();
			max = now > max? now : max;
			arr[i] = now;
		}
		M = sc.nextLong();
		long left = 1; long right = max;
		while(left <= right) {
			long mid = (left+right)/2;
			if(check(mid)) left = mid + 1;
			else right = mid - 1;
		}
		System.out.println(right);
	}
	static boolean check(long mid) {
		long total = 0;
		for(int i = 0; i < N; i++) {
			long tmp = arr[i] < mid? arr[i] : mid;
			total += tmp;
		}
		if(total <= M) return true;
		else return false;
	}
}
