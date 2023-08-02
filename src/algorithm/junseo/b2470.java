package algorithm.junseo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class b2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;

        /////////////////////////////////////////////////////////////////////////////
        int ans1=0;
        int ans2=0;
        int sum = 0;
        while(start<end) {
            sum =Math.abs(arr[end] + arr[start]);
            if (sum == 0) {
                ans1 = arr[start];
                ans2 = arr[end];
                break;
            }
            if (sum < min) {
                min = sum;
                ans1 = arr[start];
                ans2 = arr[end];
            }
            if (arr[end] + arr[start]< 0) {
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}

