import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int arr[][] = new int[101][101];
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(i == j) arr[i][j] = 0;
				else {
					arr[i][j] = 100_000_001;
				}
			}
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(arr[s][e] > w) arr[s][e] = w;
		}
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(arr[i][k]+arr[k][j] < arr[i][j]) arr[i][j] = arr[i][k]+arr[k][j]; 
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(arr[i][j] ==  100_000_001) bw.write(0+" ");
				else {
					bw.write(arr[i][j]+" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
