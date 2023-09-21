package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16401
 * 과자 나눠주기
 * 실버 2
 * https://www.acmicpc.net/problem/16401
 */
public class b16401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] l = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, l[i]);
        }

        System.out.println(binarySearch(l, m, 1, max));
    }

    public static int binarySearch(int[] l, int m, int start, int end) {
        int answer = 0;

        while (start <= end) {
            int mid = (end + start) / 2;
            int cnt = 0;

            for (int i = 0; i < l.length; i++) {
                cnt += l[i] / mid;
            }

            if (cnt >= m) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

}
