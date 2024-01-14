package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 2660
 * 회장뽑기
 * 골드 5
 * https://www.acmicpc.net/problem/2660
 */
public class b2660 {

    static List<Integer>[] g;
    static int n;

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //학생 수

        g = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            g[i] = new ArrayList<Integer>();
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while(a != -1 && b != -1) {
            g[a].add(b);
            g[b].add(a);

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n + 1];
        int min = 100;
        int cnt = 0;

        for(int i = 1; i < n + 1; i++) {

            answer[i] = bfs(i);

            if(min == answer[i])
                cnt++;
            else if(answer[i] < min){
                cnt = 1;
                min = answer[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(cnt).append("\n");

        for(int i = 1; i < n + 1; i++) {
            if(answer[i] == min)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static int bfs(int cur) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[cur] = true;
        q.add(cur);

        int d = -1;
        while(!q.isEmpty()) {
            d++;
            int size = q.size();

            for(int i = 0; i < size; i++) {
                cur = q.poll();

                for(int j = 0 ; j < g[cur].size(); j++) {
                    if(visited[g[cur].get(j)])
                        continue;

                    visited[g[cur].get(j)] = true;
                    q.add(g[cur].get(j));
                }
            }


        }

        return d;
    }
}
