import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MaxSang {
	static char A[];
	static int n, length, max;
	static ArrayList<HashSet<Integer>> visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = st.nextToken().toCharArray();
			n = Integer.parseInt(st.nextToken());
			length = A.length;
			visit = new ArrayList<>();
			for(int i = 0; i <= n; i++) {
				visit.add(new HashSet<>());
			}
			max = 0;
			swap(0);
			System.out.println("#"+t+" "+max);
		}
	}
	static void swap(int r) {
		if(r == n) {
			max = Math.max(max, Integer.parseInt(new String(A)));
			return;
		}
		
		int val = Integer.parseInt(new String(A));
		if(visit.get(r).contains(val)) return;
		visit.get(r).add(val);
		
		for(int i = 0; i < length-1; i++) {
			for(int j = i+1; j < length; j++) {
				char temp = A[i]; //바꾸고
				A[i] = A[j];
				A[j] = temp;
				
				swap(r+1);
				
				temp = A[i]; //복구
				A[i] = A[j];
				A[j] = temp;
			}
		}
	}
}
