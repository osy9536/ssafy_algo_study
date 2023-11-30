package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[d+1];
        
        arr[c] = 3001;
        int[] sushi = new int[n];
        
        int cnt = 1;
        
        for (int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
        
        for (int i = 0; i < k; i++) {
			int idx = sushi[i];
			if (arr[idx] == 0) cnt++;
			arr[idx]++;
		}
        
        int max = cnt;
        
        for (int i = 0; i < n-1; i++) {
			int first = sushi[i];
			int last = sushi[i + k < n ? i + k : (i+k) % n];
			if (--arr[first] == 0) cnt--;
			if (++arr[last] == 1) cnt++;
			max = Math.max(max, cnt);
		}
        
        System.out.println(max);
	}
}
