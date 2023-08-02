package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1244 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int start = b-1;
			int end = b+1;
			// 0 0 1 0 1 0 0 0 1
			// 0 0 1 1 1 0 1 0 1
			// 0 1 0 0 0 1 1 0 1
			if(a==1) {
				for(int j = 1; j<=n; j++) {
					if(j%b==0) {
						if(arr[j]==1) arr[j]=0;
						else arr[j] =1;
					}
				}
			}else {
				while(start>0 && end<=n) {
					if(arr[start]==arr[end]) {
						start--;
						end++;
					}else {
						break;
					}
				}
				for(int j = start+1; j<end; j++) {
					if(arr[j]==1) arr[j]=0;
					else arr[j] =1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int j =1; j<=n; j++) {
			if(j%20==0) {
				sb.append(arr[j]).append("\n");
			}else {
				sb.append(arr[j]).append(" ");
			}
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.print(sb.toString());
	}

}
