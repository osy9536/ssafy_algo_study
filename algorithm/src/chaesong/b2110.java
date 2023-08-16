import java.util.Arrays;
import java.util.Scanner;

public class b2110 {
	static int N;
	static int C;
	static long arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		arr = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		int left = 1; int right = 1000000000;
		while(left <= right) {
			int mid = (left+right)/2;
			if(check(mid)) {
				left = mid + 1;
			}
			else right = mid - 1;
		}
		System.out.println(right);
	}
	static boolean check(int d) {
		//d만큼의 거리 차이를 둔다면 c개의 공유기를 설치할 수 있는가?
		//제일 왼쪽부터 시작
		long left = arr[0]; int cnt = 1;
		for(int i = 0; i < N; i++) {
			if(left + d <= arr[i]) {
				cnt++;
				left = arr[i];
			}
		}
		return cnt >= C;
	}
}
