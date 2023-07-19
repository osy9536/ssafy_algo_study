package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class b1764 {
	public static boolean isin(String[] notListen, String name, int n) {
		int start = 0;
		int end = n-1;
		
		for (int i = 0; i < notListen.length; i++) {
			int mid = (start+end)/2;
			if (start==end) {
				if (notListen[start].compareTo(name) == 0) return true;
				else return false;
			} else if (start>end) return false;
			
			if (notListen[mid].compareTo(name) == 0) {
				return true;
			} else if (notListen[mid].compareTo(name) < 0) { // 더 뒤면
				start = mid + 1;
			} else { // 더 앞이면
				end = mid;
			}

		}
		
		return false;

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = bf.readLine().split(" ");
		int n = Integer.parseInt(s[0]);//sc.nextInt();
		int m = Integer.parseInt(s[1]);
		
		String[] notListen = new String[n];
		String notSee = "";
		int nm = (n<m)? m: n;
		String[] result = new String[nm];
		
		for (int i = 0; i < notListen.length; i++) {
			notListen[i] = bf.readLine();
		}
		
		Arrays.sort(notListen);
		
		
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			notSee = bf.readLine();
			if(isin(notListen, notSee, n)) {
				result[cnt] = notSee;
				cnt++;
			}
		}
		
		bw.write(String.valueOf(cnt)+"\n");
		
		String[] resultsort = new String[cnt];
		System.arraycopy(result, 0, resultsort, 0, cnt);
		Arrays.sort(resultsort);
		for (int i = 0; i < cnt; i++) {
			bw.write(resultsort[i]+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
