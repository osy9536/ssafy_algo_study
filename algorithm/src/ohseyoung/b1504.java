package algorithm.src.ohseyoung;

import java.io.*;
import java.util.*;

// 특정한 최단 경로
// gold 4
class b1504 {

    static class Node implements Comparable<Node> {
        int e, w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }

    static int n, e;
    static int[] dist;
    static List<Node>[] list;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, dist));
            list[b].add(new Node(a, dist));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int case1 = calculateCase(1, v1, v2, n);
        int case2 = calculateCase(1, v2, v1, n);

        int ans = 0;
        if (case1 == -1 && case2 == -1) {
            ans = -1;
        } else if (case1 == -1) {
            ans = case2;
        } else if (case2 == -1) {
            ans = case1;
        } else
            ans = Math.min(case1, case2);

        System.out.println(ans);
    }

    static int calculateCase(int start, int mid, int end, int destination) {
        int result = 0;

        int startToMid = dijkstra(start, mid);
        int midToEnd = dijkstra(mid, end);
        int endToDestination = dijkstra(end, destination);

        if (startToMid == -1 || midToEnd == -1 || endToDestination == -1) {
            result = -1;
        } else {
            result = startToMid + midToEnd + endToDestination;
        }

        return result;
    }


    private static int dijkstra(int v1, int v2) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[v1] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.add(new Node(v1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.e]) {
                continue;
            }
            visited[cur.e] = true;

            for (int i = 0; i < list[cur.e].size(); i++) {

                Node next = list[cur.e].get(i);

                if (dist[next.e] > dist[cur.e] + next.w) {
                    dist[next.e] = dist[cur.e] + next.w;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }

        if (dist[v2] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[v2];
    }
}
