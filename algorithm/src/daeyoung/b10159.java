package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 10159
 * 저울
 * 골드 4
 * https://www.acmicpc.net/problem/10159
 */
public class b10159 {

    static List<Integer>[] g;
    static int d;
    static int[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        g = new ArrayList[n + 1];

        for(int i = 0; i < n + 1; i++)
            g[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            g[x].add(y);
        }

        check = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            d = 0;
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;
            bfs(i, visited);
            check[i] += d;
        }


        for(int i = 1; i < n + 1; i++)
            System.out.println(n - check[i]);
    }

    public static void dfs(int cur, boolean[] visited) {

        check[cur] += 1;

        for(int next : g[cur]) {
            if(visited[next])
                continue;

            visited[next] = true;
            d += 1;
            dfs(next, visited);
        }

    }

    public static void bfs(int cur, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(cur);

        while (!q.isEmpty()) {

            cur = q.poll();

            check[cur] += 1;

            for (int next : g[cur]) {
                if(visited[next])
                    continue;

                visited[next] = true;
                q.add(next);
                d += 1;
            }
        }
    }
}
