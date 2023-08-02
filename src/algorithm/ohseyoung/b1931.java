package algorithm.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] arr= new int[n][2];
		
		for(int i = 0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
	        arr[i][0]=a;
	        arr[i][1]=b;
		}
		
		Arrays.sort(arr,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
			
		});
		int cnt =0;
		int last = 0;
		for(int i = 0; i<n; i++) {
			int a= arr[i][0];
			int b = arr[i][1];
			if(a>=last) {
				last=b;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
