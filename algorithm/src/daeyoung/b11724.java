package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 11724
 * 연결 요소의 개수
 * https://www.acmicpc.net/problem/11724
 */
public class b11724 {

    static int[] parent;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); //간선 개수

        parent = new int[n + 1];

        for(int i = 1; i < n + 1; i++)
            parent[i] = i;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            union(u, v);
        }

        Set<Integer> s = new HashSet<>();

        for(int i = 1; i < n + 1; i++)
            s.add(find(i));

        System.out.println(s.size());

    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b)
            return false;

        if(a <= b)
            parent[b] = a;
        else
            parent[a] = b;

        return true;
    }

    public static int find(int a) {
        if(parent[a] == a)
            return a;
        else
            return find(parent[a]);
    }
}
