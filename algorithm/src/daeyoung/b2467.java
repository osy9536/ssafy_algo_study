package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2467
 * 용액
 * 골드 5
 * https://www.acmicpc.net/problem/2467
 */
public class b2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] sols = new long[n]; //이미 오름차순

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sols[i] = Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = n - 1;
        long[] answer = new long[2];
        long min = Long.MAX_VALUE;
        while(start < end) {
            long sum = sols[start] + sols[end];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = sols[start];
                answer[1] = sols[end];
            }

            if(sum >= 0)
                end--;
            else
                start++;

        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
