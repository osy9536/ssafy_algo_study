import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr1[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int arr2[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		for(int i = 0; i < M; i++) {
			boolean ans = binarySearch(arr2[i], arr1);
			if(ans) System.out.println(1);
			else System.out.println(0);
		}
	}
	static boolean binarySearch(int n, int[] arr) {
		int start = 0; int end = arr.length-1;
		while(start <= end) {
			int middle = (start + end) / 2;
			if(arr[middle] == n) {
				return true;
			}
			else if(arr[middle] > n) {
				end = middle - 1;
				continue;
			}
			else {
				start = middle + 1;
				continue;
			}
		}
		return false;
	}

}
