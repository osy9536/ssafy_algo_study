package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 2251
 * 물통
 * 골드 5
 * https://www.acmicpc.net/problem/2251
 */
public class b2251 {

    static boolean[][][] check = new boolean[201][201][201];
    static int a;
    static int b;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dfs(0, 0, c);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < 201; i++)
            for(int j = 0; j < 201; j++)
                if(check[0][i][j])
                    pq.add(j);

        while(!pq.isEmpty())
            System.out.print(pq.poll() + " ");
    }

    public static void dfs(int curA, int curB, int curC) {

        if(check[curA][curB][curC])
            return;

        check[curA][curB][curC] = true;

        //a -> b
        if(curA > 0 && curB < b) {
            if(b - curB > curA) {
                dfs(0, curA + curB, curC);
            } else if(b - curB == curA) {
                dfs(0, b, curC);
            } else
                dfs(curA - b + curB, b, curC);
        }

        //a -> c
        if(curA > 0 && curC < c) {
            if(c - curC > curA) {
                dfs(0, curB, curA + curC);
            } else if(c - curC == curA) {
                dfs(0, curB, c);
            } else
                dfs(curA - c + curC, curB, c);
        }

        //b -> a
        if(curB > 0 && curA < a) {
            if(a - curA > curB)
                dfs(curA + curB, 0, curC);
            else if(a - curA == curB)
                dfs(a, 0, curC);
            else
                dfs(a, curB - a + curA, curC);
        }

        //c -> a
        if(curC > 0 && curA < a) {
            if(a - curA > curC)
                dfs(curA + curC, curB, 0);
            else if(a - curA == curC)
                dfs(a, curB, 0);
            else
                dfs(a, curB, curC + curA - a);
        }

        //b -> c
        if(curB > 0 && curC < c) {
            if(c - curC > curB)
                dfs(curA, 0, curB + curC);
            else if(c - curC == curB)
                dfs(curA, 0, c);
            else
                dfs(curA, curB - c + curC, c);
        }

        //c -> b
        if(curC > 0 && curB < b) {
            if(b - curB > curC)
                dfs(curA, curC + curB, 0);
            else if(b - curB == curC)
                dfs(curA, b, 0);
            else
                dfs(curA, b, curC - b + curB);
        }
    }
}
