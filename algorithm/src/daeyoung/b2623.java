package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 2623
 * 음악프로그램
 * 골드 3
 * https://www.acmicpc.net/problem/1967
 */
public class b2623 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //가수의 수
        int m = Integer.parseInt(st.nextToken()); //보수PD의 수

        int[] indegree = new int[n + 1];
        List<List<Integer>> g = new ArrayList<>();

        for(int i = 0; i < n + 1; i++) {
            g.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num == 1)
                continue;

            int[] temp = new int[num];

            for(int j = 0; j < num; j++)
                temp[j] = Integer.parseInt(st.nextToken());

            for(int j = 1; j < num; j++) {
                int a = temp[j - 1];
                int b = temp[j];

                g.get(a).add(b);
                indegree[b]++;
            }
        }

        if(topologicalSort(indegree, g))
            System.out.println(sb.toString());
        else
            System.out.println(0);
    }

    public static boolean topologicalSort(int[] indegree, List<List<Integer>> g) {
        Queue<Integer> q = new LinkedList<Integer>();
        int n = indegree.length;

        for(int i = 1; i < n; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append("\n");

            for(Integer i : g.get(cur)) {
                indegree[i]--;

                if(indegree[i] == 0)
                    q.offer(i);
            }
        }

        for(int i = 1; i < n; i++)
            if(indegree[i] != 0)
                return false;

        return true;
    }
}
