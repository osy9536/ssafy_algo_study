import java.util.*;
import java.io.*;

public class b2042 {
	static long[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int treeH = 0;
		int length = N;
		while(length != 0) {
			length /= 2;
			treeH++;
		}
		int treeSize = (int)Math.pow(2, treeH+1);
		int leftIndex = treeSize/2 -1;
		tree = new long[treeSize+1];
		//리프노드 채우기
		for(int i = leftIndex+1; i <= leftIndex+N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		} 
		init(treeSize); 
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			if(a == 1) {
				update(leftIndex+s, e);
			}else if(a == 2){
				//트리 인덱스로 변경 
				s += leftIndex;
				e += leftIndex;
				bw.write(getSum(s, (int)e) + "\n");
			}else {
				return;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void init(int i) {
		while(i != 1) {
			tree[i/2] += tree[i];
			i--;
		}
	}
	private static long getSum(int s, int e) {
		long partSum = 0;
		while(s <= e) {
			if(s % 2 == 1) {
				partSum = partSum + tree[s];
				s++;
			}
			if(e % 2 == 0) {
				partSum = partSum + tree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return partSum;
	}
	private static void update(int index, long val) {
		long diff = val - tree[index];
		while(index > 0) {
			tree[index] = tree[index] + diff;
			index /= 2;
		}
	}
}
