package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1697 {

	static int N,K;
	static int[] res;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		res = new int[100010];
		res[N] = 0;
		
		while(!queue.isEmpty()) {
			int std = queue.poll();
			if(std==K) {
				
				break;
			}
			if(std-1>=0&&res[std-1] ==0) {
				queue.offer(std-1);
				res[std-1] = res[std]+1;	
			}
			
			if(std+1<=100000&&res[std+1] ==0) {
				queue.offer(std+1);
				res[std+1] = res[std]+1;	
			}
			if(std*2<=100000&&res[std*2] ==0) {
				queue.offer(std*2);
				res[std*2] = res[std]+1;	
			}
		}
		System.out.println(res[K]);
	}

}


