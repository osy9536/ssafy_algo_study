package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2805
 * 나무 자르기
 * 실버2
 * https://www.acmicpc.net/problem/2805
 */
public class b2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //나무 수
        int n = Integer.parseInt(st.nextToken());
        //필요한 나무 길이
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int start = 0;
        int end = trees[n - 1];
        int answer = 0;

        while(start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;

            for(int h : trees) {
                if(h > mid)
                    sum += (h - mid);
            }

            if(sum >= m) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);


    }
}
