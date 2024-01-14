package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분합
// gold 4
public class b1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int total = 0;
        while (left <= n && right <= n) {
            if (total >= s && min > right - left) min = right - left;

            if (total < s) total += nums[right++];
            else total -= nums[left++];
        }

        if (min == Integer.MAX_VALUE) min=0;
        System.out.println(min);
    }
}
