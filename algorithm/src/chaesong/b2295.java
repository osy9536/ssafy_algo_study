import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class b2295 {
	static int N;
	static int[] n, hap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		n = new int[N];
		hap = new int[N*N];
		for(int i = 0; i < N; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(n);
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				hap[idx] = n[i] + n[j];
				idx++; 
			}
		}
		Arrays.sort(hap, 0, idx-1);
		for(int i = N-1; 0 <= i; i--) {
			for(int j = i; 0 <= j; j--) {
				if(Arrays.binarySearch(hap, 0, idx-1, n[i]-n[j]) < 0) continue;
				else {
					bw.write(String.valueOf(n[i]));
					bw.flush();
					bw.close();
					return;
				}				
			}
		}
	}
}
