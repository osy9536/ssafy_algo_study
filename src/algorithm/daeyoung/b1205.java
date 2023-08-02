package algorithm.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1205
 * 등수 구하기
 * 실버4
 * https://www.acmicpc.net/problem/1205
 */
public class b1205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long newScore = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Long[] scores = new Long[n];
        if(n != 0)
            st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(scores, Collections.reverseOrder());

        if(n == p && newScore <= scores[n - 1])
            System.out.println(-1);
        else {
            int rank = 1;
            for(int i = 0; i < n; i++) {
                if(newScore < scores[i])
                    rank++;
                else
                    break;
            }
            System.out.println(rank);
        }

    }
}
