package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long mn,mx;
		mn = Long.parseLong(st.nextToken());
		mx = Long.parseLong(st.nextToken());
		
		int sqrt = (int) Math.sqrt(mx);
		int arrLength =  (int) (mx-mn+1);
		boolean [] arr = new boolean[arrLength];
		
		for (long i = 2; i <= sqrt; i++) {
			
			long pow = i*i;
			long start_idx = mn/pow;
			if(mn%pow != 0) start_idx++;
			
			for (long j = start_idx; j*pow <= mx; j++) {
				arr[(int) (j*pow-mn)] = true;
			}
			
		}
		
		int cnt = 0;
		for (int i = 0; i < arrLength ; i++) {
			if(!arr[i]) cnt++;
		}
		System.out.println(cnt);
		
	}

}


