package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 5972
 * 택배 배송
 * 실버 5
 * https://www.acmicpc.net/problem/5972
 */
public class b5972 {

    static int INF;

    static class Node implements Comparable<Node> {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //vertex num
        int m = Integer.parseInt(st.nextToken()); //edge num
        INF = Integer.MAX_VALUE;

        List<Node>[] g = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++)
            g[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            g[a].add(new Node(b, cost));
            g[b].add(new Node(a, cost));
        }

        System.out.println(dijkstra(g, 1, n));
    }

    public static int dijkstra(List<Node>[] g, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] distance = new int[end + 1];
        boolean[] visited = new boolean[end + 1];

        for(int i = 1; i < end + 1; i++) {
            distance[i] = INF;
        }

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.n])
                continue;

            visited[cur.n] = true;

            for(Node next : g[cur.n]) {
                if(distance[next.n] > distance[cur.n] + next.cost) {
                    distance[next.n] = distance[cur.n] + next.cost;
                    pq.add(new Node(next.n, distance[next.n]));
                }
            }

        }

        return distance[end];
    }
}
