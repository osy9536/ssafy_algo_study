package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 용액
// gold 5
public class b2467 {
	static int[] arr;
	static int right,left, n;
	static long dif;
    static long[] answer = new long[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		dif = Integer.MAX_VALUE;
		
		for(int i = 0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
		}
		
		Arrays.sort(arr);
		find(0,n-1);
		Arrays.sort(answer);
        System.out.println(answer[0]+" "+answer[1]);
	}
	private static void find(int left, int right) {
		while(left<right) {
			long sum = arr[left] + arr[right];
            long absSum = Math.abs(sum);
            if(absSum<dif){
                answer[0] = arr[left];
                answer[1] = arr[right];
                dif = absSum;
            }
            if(sum>0){
                right--;
            }else if(sum<0) left++;
            else {
                Arrays.sort(answer);
                System.out.println(answer[0]+" "+answer[1]);
                System.exit(0);
            }
		}
	}
}
