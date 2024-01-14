package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 13913
 * 숨바꼭질4
 * 골드 4
 * https://www.acmicpc.net/problem/13913
 */
public class b13913 {

    static int n; //수빈이가 있는 위치
    static int k; //동생의 위치

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(sb);
    }

    public static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] path = new int[100001];

        int[] cur = new int[2];

        cur[1] = n;

        visited[n] = true;
        q.add(cur);

        while(!q.isEmpty()) {
            cur = q.poll();

            if(cur[1] == k) {
                sb.append(cur[0]).append("\n");

                List<Integer> temp = new ArrayList<>();
                temp.add(cur[1]);
                int next = path[cur[1]];

                int index = cur[0];

                while(index != 0) {
                    temp.add(next);
                    next = path[next];
                    index--;
                }

                for(int i = temp.size() - 1; i >= 0; i--)
                    sb.append(temp.get(i)).append(" ");

                break;
            }

            if(cur[1] + 1 < 100001 && !visited[cur[1] + 1]) {
                q.add(new int[] {cur[0] + 1, cur[1] + 1});
                visited[cur[1] + 1] = true;
                path[cur[1] + 1] = cur[1];
            }

            if(cur[1] - 1 >= 0 && !visited[cur[1] - 1]) {
                q.add(new int[] {cur[0] + 1, cur[1] - 1});
                visited[cur[1] - 1] = true;
                path[cur[1] - 1] = cur[1];
            }

            if(cur[1] * 2 < 100001 && !visited[cur[1] * 2]) {
                q.add(new int[] {cur[0] + 1, cur[1] * 2});
                visited[cur[1] * 2] = true;
                path[cur[1] * 2] = cur[1];
            }
        }

    }
}
