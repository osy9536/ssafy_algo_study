import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6236 {
	static int N;
	static int M;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = max < arr[i]? arr[i] : max;
		}
		int left = 1; int right = max*N;
		int result = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			if(check(mid)) {
				result = mid;
				right = mid-1;
			}
			else left = mid+1;
		}
		System.out.println(result);
	}
	static boolean check(int mid) {
		int cnt = 1; int now = mid;
		for(int i = 0; i < N; i++) {
			if(mid < arr[i]) {
				cnt = 100001;
				break;
			}
			else {
				now -= arr[i];
				if(now < 0) {
					cnt++;
					now = mid - arr[i];
				}				
			}
		}
		return cnt <= M;
	}
}
