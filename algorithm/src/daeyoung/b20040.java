package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 20040
 * 사이클 게임
 * 골드 4
 * https://www.acmicpc.net/problem/20040
 */
public class b20040 {

    static int n; //점의 수
    static int m; //진행될 차례의 수

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(!union(x, y)) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(0);
    }

    public static boolean union(int x, int y) {

        x = find(x);
        y = find(y);

        if(x == y) return false;

        if(x <= y)
            parent[y] = x;
        else
            parent[x] = y;

        return true;
    }

    public static int find(int x) {

        if(parent[x] == x)
            return x;

        return find(parent[x]);
    }
}
