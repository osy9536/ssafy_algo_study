package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 18870
 * 좌표 압축
 * 실버 2
 * https://www.acmicpc.net/problem/18870
 */
public class b18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] ary = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            ary[i] = cur;
            set.add(cur);
        }

        int[] sorted = new int[set.size()];
        int index = 0;
        for(Integer i : set)
            sorted[index++] = i;

        Arrays.sort(sorted);



        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(Arrays.binarySearch(sorted, ary[i])).append(" ");
        }

        System.out.println(sb);
    }
}
