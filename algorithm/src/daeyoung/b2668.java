package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 2668
 * 숫자고르기
 * 골드 5
 * https://www.acmicpc.net/problem/2668
 */
public class b2668 {

    static int n;
    static boolean check;
    static int[] nums;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            int cur = Integer.parseInt(br.readLine());
            nums[i] = cur;
        }

        pq = new PriorityQueue<>();
        for(int i = 1; i < n + 1; i++) {
            check = false;
            dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) {
            int cur = pq.poll();

            sb.append(cur).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start, int cur) {
        for(int i = 1; i < n + 1; i++) {
            if(nums[i] == cur) {
                if(start == i) {
                    pq.add(start);
                    check = true;
                    return;
                }
                dfs(start, i);
            }
        }
    }


}
