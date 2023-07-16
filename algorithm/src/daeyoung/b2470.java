package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 백준 2470
 * 두 용액
 * 골드5
 * https://www.acmicpc.net/problem/2470
 */
public class b2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        int start = 0;
        int end = n - 1;
        int mix = ary[end] + ary[start];
        int a = start;
        int b = end;

        while(start < end) {

            if(Math.abs(ary[end] + ary[start]) < Math.abs(mix)) {
                a = start;
                b = end;
                mix = ary[end] + ary[start];
            }

            if(mix == 0)
                break;

            if(Math.abs(ary[end-1] + ary[start]) < Math.abs(ary[end] + ary[start + 1]))
                end--;
            else
                start++;
        }

        System.out.println(ary[a] + " " + ary[b]);

    }
}
