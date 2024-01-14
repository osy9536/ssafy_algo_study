import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		long lo = 1;
		long hi = K;
		
		while(lo < hi) {
			long mid = (long)((lo+hi)/2);
			long cnt = 0;
			
			for(int i = 1; i <= N; i++) {
				cnt += Math.min(mid/i, N);
			}
			
			if(cnt < K) {
				lo = mid+1;
			}else {
				hi = mid;
			}
		}
		System.out.println(hi);
	}
}
