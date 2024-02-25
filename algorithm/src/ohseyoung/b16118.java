package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b16118 {

    static class Node implements Comparable<Node> {
        int e, w, depth;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        public Node(int e, int w, int depth) {
            this.e = e;
            this.w = w;
            this.depth = depth;
        }

        @Override
        public int compareTo(Node o1) {
            return this.w - o1.w;
        }
    }

    static int n, m;
    static List<Node>[] lists;
    static int[] foxDist;
    static int[][] wolfDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lists = new List[n + 1];
        foxDist = new int[n + 1];
        wolfDist = new int[2][n + 1];
        Arrays.fill(foxDist, Integer.MAX_VALUE);
        Arrays.fill(wolfDist[0], Integer.MAX_VALUE);
        Arrays.fill(wolfDist[1], Integer.MAX_VALUE);

        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            lists[a].add(new Node(b, l*2));
            lists[b].add(new Node(a, l*2));
        }

        foxDijkstra();
        wolfDijkstra();

        int ans = 0;
        for (int i = 2; i < n + 1; i++) {
            if (foxDist[i] < Math.min(wolfDist[0][i], Math.min(Integer.MAX_VALUE, wolfDist[1][i]))) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void foxDijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        foxDist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(foxDist[cur.e]<cur.w) continue;
            for (Node node : lists[cur.e]) {
                int cost = cur.w + node.w;
                if (cost < foxDist[node.e]) {
                    foxDist[node.e] = cost;
                    pq.add(new Node(node.e, cost));
                }
            }
        }
    }

    static void wolfDijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 0));
        wolfDist[0][1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (wolfDist[cur.depth][cur.e] < cur.w) {
                continue;
            }
            for (Node node : lists[cur.e]) {

                int cost = cur.w + (cur.depth == 0 ? node.w / 2 : node.w * 2);
                if (cost < wolfDist[1 - cur.depth][node.e]) {
                    wolfDist[1 - cur.depth][node.e] = cost;
                    pq.add(new Node(node.e, cost, 1 - cur.depth));
                }
            }
        }
    }
}
