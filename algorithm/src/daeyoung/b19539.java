package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 19539
 * 사과나무
 * 골드 5
 * https://www.acmicpc.net/problem/19539
 */
public class b19539 {

    static int n;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         trees = new int[n];
         int sum = 0;
         st = new StringTokenizer(br.readLine());
         for(int i = 0; i < n; i++) {
             trees[i] = Integer.parseInt(st.nextToken());
             sum += trees[i];
         }

         StringBuilder sb = new StringBuilder();
         if(sum % 3 == 0) {
             int totalDays = sum / 3;
             int twoDays = 0;

             for(int i : trees) {
                 twoDays += i / 2;
             }

             if(twoDays >= totalDays)
                 sb.append("YES");
             else
                 sb.append("NO");
         } else {
             sb.append("NO");
         }

        System.out.println(sb);
    }

}
