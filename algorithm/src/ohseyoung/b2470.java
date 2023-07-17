package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 용액
public class b2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);
        int num1 = 0, num2 = 0;

        while (left < right) {
            int closeZero = arr[left] + arr[right] > 0 ? arr[left] + arr[right] : -(arr[left] + arr[right]);
            if (min > closeZero) {
                min = closeZero;
                num1 = arr[left];
                num2 = arr[right];
            }
            if(arr[left]+arr[right]<0) left++;
            else right--;
            // -99 -2 -1 4 98
            // -80 -70 -60 -4 0 4 15 61 88
        }
        System.out.println(num1 + " " + num2);
    }
}
