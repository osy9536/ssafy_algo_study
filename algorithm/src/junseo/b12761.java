package algorithm.src.junseo;

package w1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b12761 {
	static ArrayDeque<Integer> queue;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A,B,N,M;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[100001];
		queue = new ArrayDeque<>();
		
		queue.add(N);
		
		for (int i = 0; i <= 100000; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
		arr[N] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			int l = cur -1;
			int r = cur +1;
			int la = cur - A;
			int ra = cur + A;
			int lb = cur - B;
			int rb = cur + B;
			int ra2 = cur * A;
			int rb2 = cur * B;
			check(cur,l);
			check(cur,r);
			check(cur,la);
			check(cur,ra);
			check(cur,lb);
			check(cur,rb);
			check(cur,ra2);
			check(cur,rb2);
//			if (l <= 100000 && l>=0) {
//				if(arr[l] > arr[cur]+1) {
//					arr[l] = arr[cur]+1;
//					queue.add(l);
//				}
//			}
//			if (r <= 100000 && r>=0) {
//				if(arr[r] > arr[cur]+1) {
//					arr[r] = arr[cur]+1;
//					queue.add(r);
//				}
//			}
//			if (la <= 100000 && la>=0) {
//				if(arr[la] > arr[cur]+1) {
//					arr[la] = arr[cur]+1;
//					queue.add(la);
//				}
//			}
//			if (ra <= 100000 && ra>=0) {
//				if(arr[ra] > arr[cur]+1) {
//					arr[ra] = arr[cur]+1;
//					queue.add(ra);
//				}
//			}
//			if (lb <= 100000 && lb>=0) {
//				if(arr[lb] > arr[cur]+1) {
//					arr[lb] = arr[cur]+1;
//					queue.add(lb);
//				}
//			}
//			if (rb <= 100000 && rb>=0 ) {
//				if(arr[rb] > arr[cur]+1) {
//					arr[rb] = arr[cur]+1;
//					queue.add(rb);
//				}
//			}
//			if (ra2 <= 100000 && ra2>=0) {
//				if(arr[ra2] > arr[cur]+1) {
//					arr[ra2] = arr[cur]+1;
//					queue.add(ra2);
//				}
//			}
//			if (rb2 <= 100000 && rb2>=0 ) {
//				if(arr[rb2] > arr[cur]+1) {
//					arr[rb2] = arr[cur]+1;
//					queue.add(rb2);
//				}
//			}
		}
		System.out.println(arr[M]);
	}
	private static void check(int cur,int move) {
		if (move <= 100000 && move >= 0) {
			if (arr[move] > arr[cur] + 1) {
				arr[move] = arr[cur] + 1;
				queue.add(move);
			}
		}
	}
}


