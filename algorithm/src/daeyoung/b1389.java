package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1389
 * 케빈 베이컨의 6단계 법칙
 * 실버 1
 * https://www.acmicpc.net/problem/1389
 */
public class b1389 {

    static int n; //유저의 수
    static int m; //친구 관계의 수
    static List<Integer>[] relation;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        relation = new ArrayList[n];

        //초기화
        for (int i = 0; i < n; i++) {
            relation[i] = new ArrayList<Integer>();
        }

        //값 받기
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken()) - 1;
            int p2 = Integer.parseInt(st.nextToken()) - 1;

            relation[p1].add(p2);
            relation[p2].add(p1);
        }

//        int[] k = new int[n];

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                min = Integer.MAX_VALUE;
//
//                if(i == j)
//                    continue;
//
//                dfs(i, j, new boolean[n], 0);
//                k[i] += min;
//            }
//        }

        int cost = Integer.MAX_VALUE;
        int answer = -1;
//        for(int i = 0; i < n; i++) {
//
//            if(k[i] < cost) {
//                cost = k[i];
//                answer = i;
//            }
//
//        }

        for (int i = 0; i < n; i++) {
            int sum = bfs(i);
            if (sum < cost) {
                cost = sum;
                answer = i;
            }
        }

        System.out.println(answer + 1);
    }

//    public static void dfs(int cur, int end, boolean[] visited, int step) {
//        if(cur == end) {
//            min = Math.min(min, step);
//            return;
//        }
//
//        for(int i = 0; i < relation[cur].size(); i++) {
//            int next = relation[cur].get(i);
//
//            if(visited[next])
//                continue;
//            visited[next] = true;
//            dfs(next, end, visited, step + 1);
//            visited[next] = false;
//        }
//    }

    public static int bfs(int cur) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> q = new ArrayDeque<>();
        q.add(cur);
        dist[cur] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for(int next : relation[curr]) {
                if(dist[next] > dist[curr] + 1) {
                    dist[next] = dist[curr] + 1;
                    q.add(next);
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += dist[i];

        return sum;
    }

}
