import java.util.*;
import java.io.*;

public class b11505 {
	static long tree[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int treeH = 0;
		int length = N;
		while(0 < length) {
			length /= 2;
			treeH++;
		}
		int treeSize = (int)Math.pow(2, treeH+1);
		tree = new long[treeSize+1];
		for(int i = 1; i <= treeSize; i++) {
			tree[i] = 1;
		}
		int leftIndex = treeSize/2-1;
		for(int i = leftIndex+1; i <= leftIndex+N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		init(treeSize);
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				b = b+leftIndex;
				tree[b] = c;
				update(b, c);
			}else {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				s += leftIndex;
				e += leftIndex;
				System.out.println(multiple(s, e));
			}
		}
	}
	static void init(int n) {
		while(0 < n) {
			tree[n/2] = tree[n/2] * tree[n] %1_000_000_007;
			n--;
		}
	}
	static void update(int b, int c) {
		while(0 < b) {
			if(b%2 == 0) { //왼쪽 자식이면
				tree[b/2] = tree[b] * tree[b+1] %1_000_000_007;
			}else {
				tree[b/2] = tree[b] * tree[b-1] %1_000_000_007;
			}
			b /= 2;
		}
	}
	static long multiple(int s, int e) {
		long multi = 1;
		while(s <= e) {
			if(s % 2 == 1) {
				multi = multi * tree[s] %1_000_000_007;
				s++;
			}
			if(e % 2 == 0) {
				multi =  multi * tree[e] %1_000_000_007;
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return multi;
	}
}
