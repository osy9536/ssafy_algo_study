import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b2015 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());	
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		int hap[] = new int[N+1];
		long ans = 0;
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			hap[i] = hap[i-1] + arr[i];
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		for(int i = 1; i <= N; i++) {
			ans += hm.getOrDefault(hap[i]-K, 0);
			hm.put(hap[i], hm.getOrDefault(hap[i], 0)+1);
		}
		System.out.println(ans);
	}
}
