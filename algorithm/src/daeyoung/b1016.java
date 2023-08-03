package algorithm.src.daeyoung;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1016
 * 제곱 ㄴㄴ 수
 * 골드 1
 * https://www.acmicpc.net/problem/1016
 */
public class Boj1016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int) (max - min + 1)];

        for(long i = 2; i <= Math.sqrt(max); i++) {
            long start = i * i;

            if(min % start == 0) {
                start = min;
            } else {
                start = (min / start + 1) * start;
            }

            for (long j = start; j <= max; j+= i * i) {
                check[(int)(j - min)] = true;
            }

        }

        int cnt = 0;
        for (boolean b : check) {
            if(!b)
                cnt++;
        }

        System.out.println(cnt);
    }
}
