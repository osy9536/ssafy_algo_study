package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 서강그라운드
// gold 4
public class b14938 {

    static class Node implements Comparable<Node> {
        int e, w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o1) {
            return this.w - o1.w;
        }
    }

    static int n, m, r;
    static int[] items;
    static List<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n + 1];
        lists = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(st.nextToken());
            items[i] = t;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            lists[a].add(new Node(b, l));
            lists[b].add(new Node(a, l));
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        System.out.println(ans);
    }

    static int dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.e]) {
                visited[cur.e] = true;

                for (Node node : lists[cur.e]) {
                    if (!visited[node.e] && dist[node.e] > node.w + dist[cur.e]) {
                        dist[node.e] = node.w + dist[cur.e];
                        pq.add(new Node(node.e, dist[node.e]));
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] <= m) {
                res += items[i];
            }
        }
        return res;
    }
}
