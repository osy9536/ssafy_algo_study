package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 1765
 * 닭싸움 팀 정하기
 * 골드 2
 * https://www.acmicpc.net/problem/1765
 */
//dfs로
public class b1765 {

    static List<Integer>[] e;
    static List<Integer>[] team;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //student num
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //relation num

        e = new ArrayList[n + 1];
        team = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            e[i] = new ArrayList<Integer>();
            team[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if(s.equals("E")) {
                e[p].add(q);
                e[q].add(p);
            } else {

                team[p].add(q);
                team[q].add(p);
            }
        }

        //원수의 원수 추가
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < e[i].size() - 1; j++) {
                team[e[i].get(j)].add(e[i].get(j + 1));
                team[e[i].get(j + 1)].add(e[i].get(j));
            }
        }

        int answer = 0;
        selected = new boolean[n + 1];

        for(int i = 1; i < n + 1; i++) {
            if(!selected[i]) {
                selected[i] = true;
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int cur) {
        for(int i : team[cur]) {

            if(!selected[i]) {
                selected[i] = true;
                dfs(i);
            }

        }
    }

}

////union find
//public class b1765 {
//
//    static List<Integer>[] e;
//    static int[] parent;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken()); //student num
//        st = new StringTokenizer(br.readLine());
//        int m = Integer.parseInt(st.nextToken()); //relation num
//
//        e = new ArrayList[n + 1];
//
//        for(int i = 0; i <= n; i++) {
//            e[i] = new ArrayList<Integer>();
//        }
//
//        parent = new int[n + 1];
//        for(int i = 1; i < n + 1; i++)
//            parent[i] = i;
//
//        for(int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            String s = st.nextToken();
//            int p = Integer.parseInt(st.nextToken());
//            int q = Integer.parseInt(st.nextToken());
//
//            if(s.equals("E")) {
//                e[p].add(q);
//                e[q].add(p);
//            } else {
//                union(p, q);
//            }
//        }
//
//        for(int i = 1; i <= n; i++) {
//            for(int j = 0; j < e[i].size() - 1; j++) {
//                union(e[i].get(j), e[i].get(j + 1));
//            }
//        }
//
//        boolean[] visited = new boolean[n + 1];
//        int answer = 0;
//        for(int i = 1; i <= n; i++) {
//            if(!visited[find(i)])
//                answer++;
//            visited[find(i)] = true;
//        }
//        System.out.println(answer);
//
//    }
//
//    public static int find(int x) {
//        if(parent[x] == x)
//            return x;
//        return find(parent[x]);
//    }
//
//    public static boolean union(int x, int y) {
//        x = find(x);
//        y = find(y);
//
//        if(x == y)
//            return false;
//
//        if(x <= y)
//            parent[y] = x;
//        else
//            parent[x] = y;
//        return true;
//    }
//}
