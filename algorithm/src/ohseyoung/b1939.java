package ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 중량제한
// gold 3
public class b1939 {

    static class Node implements Comparable<Node> {
        int node, weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }

    static List<Node>[] list;
    static int ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        BFS(a, b);
        System.out.println(ans);
    }

    private static void BFS(int start, int end) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, Integer.MAX_VALUE));

        visited = new boolean[list.length];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.node == end) {
                ans = cur.weight;
                return;
            }

            if (visited[cur.node]) {
                continue;
            }
            visited[cur.node] = true;

            for (Node neighbor : list[cur.node]) {
                int node = neighbor.node;
                int weight = neighbor.weight;

                pq.add(new Node(node, Math.min(weight, cur.weight)));
            }
        }
    }
}
