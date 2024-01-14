package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 15729
 * 방탈출
 * 실버 2
 * https://www.acmicpc.net/problem/15729
 */
public class b15729 {

    static  boolean[] cur;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cur = new boolean[n];
        boolean[] complete = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(st.nextToken().equals("1"))
                complete[i] = true;
        }

        int answer = 0;
        for(int i = 0; i < n - 2; i++) {
            if(cur[i] == complete[i])
                continue;
            answer += switching(i);
        }

        if(cur[n - 2] != complete[n - 2]) {
            answer++;
            cur[n - 2] = !cur[n - 2];
            cur[n - 1] = !cur[n - 1];
        }

        if(cur[n - 1] != complete[n - 1]) {
            answer++;
            cur[n - 1] = !cur[n - 1];
        }

        System.out.println(answer);
    }

    public static int switching(int index) {

        for(int i = index; i < index + 3; i++) {
            cur[i] = !cur[i];
        }

        return 1;
    }
}
