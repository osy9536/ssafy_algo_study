package algorithm.src.minho;

import java.io.IOException;
import java.util.Scanner;

public class b1654 {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[k];
		long end=Integer.MIN_VALUE;
		for(int i = 0 ; i < k ; i++) {
			arr[i] = sc.nextInt();
			end = (end<arr[i]) ? arr[i] : end;
		}
		long start=0, mid=(start+end)/2, answer=start;
		while(start<=end) {
			mid = (start+end)/2;
			int count = 0 ;
			for(int i = 0 ; i < k ; i++) {
				count+= arr[i]/mid;
			}
			if(count  >= n) { start = mid+1; answer = mid;}
			else if(count < n) {end = mid-1;}
		}
		System.out.println(answer);
	}
}
