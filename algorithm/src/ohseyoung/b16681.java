package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 등산
// gold 2
public class b16681 {

    static class Node implements Comparable<Node> {
        int e;
        long w;

        public Node(int e, long w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.w , node.w);
        }
    }

    static int n, m, d, e;
    static int[] height;
    static List<Node>[] lists;
    static long[] startDist, endDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 지점의 개수
        m = Integer.parseInt(st.nextToken()); // 경로의 개수
        d = Integer.parseInt(st.nextToken()); // 거리 비례 체력 소모량
        e = Integer.parseInt(st.nextToken()); // 높이 비례 성취감 획득량
        startDist = new long[n + 1];
        endDist = new long[n + 1];
        lists = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        height = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            lists[a].add(new Node(b, n));
            lists[b].add(new Node(a, n));
        }

        startDijkstra();
        endDijkstra();

        long ans = Long.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (startDist[i] == Long.MAX_VALUE || endDist[i] == Long.MAX_VALUE) continue;
            int ni = (height[i]) * e;
            long mi = (startDist[i] + endDist[i]) * d;
            long a = Math.max(ans, ni - mi);
            ans = a;
        }
        System.out.println(ans == Long.MIN_VALUE ? "Impossible" : ans);
    }

    private static void startDijkstra() {
        boolean[] visited = new boolean[n + 1];
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        Arrays.fill(startDist, Long.MAX_VALUE);
        startDist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visited[cur.e]) {
                visited[cur.e] = true;

                for (Node next : lists[cur.e]) {
                    if (height[cur.e] < height[next.e]) {
                        if (!visited[next.e] && startDist[next.e] > startDist[cur.e] + next.w) {
                            startDist[next.e] = startDist[cur.e] + next.w;
                            pq.add(new Node(next.e, startDist[next.e]));
                        }
                    }
                }
            }
        }
    }

    private static void endDijkstra() {
        boolean[] visited = new boolean[n + 1];
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));

        Arrays.fill(endDist, Long.MAX_VALUE);
        endDist[n] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visited[cur.e]) {
                visited[cur.e] = true;

                for (Node next : lists[cur.e]) {
                    if (height[cur.e] < height[next.e]) {
                        if (!visited[next.e] && endDist[next.e] > endDist[cur.e] + next.w) {
                            endDist[next.e] = endDist[cur.e] + next.w;
                            pq.add(new Node(next.e, endDist[next.e]));
                        }
                    }
                }
            }
        }
    }
}
