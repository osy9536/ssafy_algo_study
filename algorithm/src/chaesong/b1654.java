import java.util.Scanner;

public class b1654 {
	static int K; static int N;
	static long arr[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		arr = new long[K]; long max = 0;
		for(int i = 0; i < K; i++) {
			 int now = sc.nextInt();
			 max = now > max? now : max;
			 arr[i] = now;
		}
		long left = 1; long right = max;
		while(left <= right) {				
			long mid = (left+right)/2;
			if(check(mid)) left = mid+1;
			else right = mid-1;
		}
		System.out.println(right);
	}
	static boolean check(long now) {
		long cnt = 0;
		
		for(int i = 0; i < K; i++) {
			cnt += arr[i] >= now? arr[i]/now : 0;
		}
		if(cnt < N) return false;
		else return true;
	}
}
