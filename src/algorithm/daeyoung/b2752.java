package algorithm.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2752
 * 세수정렬
 * 브론즈 4
 * https://www.acmicpc.net/problem/2752
 */
public class b2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ary = new int[3];
        for (int i = 0; i < 3; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        for (int i = 0; i < 3; i++) {
            System.out.print(ary[i] + " ");
        }
    }
}
