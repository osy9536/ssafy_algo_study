package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참조  https://loosie.tistory.com/720 
 */
public class b1016_제곱ㄴㄴ수 {
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
			/*
			 * 제곱수로 나누어지는 시작 인덱스는 
			 * mn보다 크고 제곱수로 나누어져야 함 
			 * i*i = 4, mn = 20 일 때, 시작인덱스는 20
			 * i*i = 9, mn = 20 일 때, 시작인덱스는 27
			 * 9*3인 27부터 시작해야하는데 이 때 3을 구하기 위해 
			 * mn을 9로 나누고 +1을 해줌 
			 */
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


