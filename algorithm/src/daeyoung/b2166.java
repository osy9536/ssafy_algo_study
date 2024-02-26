package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 2166
 * 다각형의 면적
 * 골드 5
 * https://www.acmicpc.net/problem/2166
 */
public class b2166 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =  Integer.parseInt(st.nextToken());

        List<long[]> p = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            p.add(new long[]{a, b});
        }

        long[] first = p.get(0);
        double answer = 0;
        for(int i = 2; i < n; i++) {
            long[] second = p.get(i - 1);
            long[] third = p.get(i);

            answer += width(first, second, third);

        }
        answer = Math.abs(answer);
        answer /= 2.0;

        System.out.println(String.format("%.1f", answer));
    }

    public static double width(long[] first, long[] second, long[] third) {

        return (second[0] - first[0]) * (third[1] - first[1]) -
                (third[0] - first[0]) * (second[1] - first[1]);
    }
}
