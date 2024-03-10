package boj;

import java.io.*;
import java.util.*;

/*
 * 백준 1967
 * 트리의 지름
 * 골드 4
 * https://www.acmicpc.net/problem/1967
 */
public class b1967 {

    static class Node {
        int c;
        int w;

        public Node(int c, int w) {
            this.c = c;
            this.w = w;
        }
    }
    static List<Node>[] tree;
    static boolean[] visited;
    static int max;
    static int index = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++)
            tree[i] = new ArrayList<Node>();

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[p].add(new Node(c, w));
            tree[c].add(new Node(p, w));
        }

        visited = new boolean[n + 1];
        max = 0;

        visited[1] = true;
        dfs(1, 0);
        visited[1] = false;

        max = 0;
        visited[index] = true;
        dfs(index, 0);

        System.out.println(max);
    }

    public static void dfs(int cur, int w) {

        if(max < w) {
            max = w;
            index = cur;
        }

        for(Node next : tree[cur]) {
            if(visited[next.c])
                continue;
            visited[next.c] = true;
            dfs(next.c, w + next.w);
            visited[next.c] = false;
        }
    }
}
