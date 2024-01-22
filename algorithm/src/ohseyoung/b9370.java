package algorithm.src.ohseyoung;

import java.io.*;
import java.util.*;

// 미확인 도착지
// gold 2
class b9370 {

    static class Node implements Comparable<Node>{
        int e;
        long w;

        Node(int e, long w) {
            this.e = e;
            this.w = w;
        }

        public int compareTo(Node n ) {
            if (this.w - n.w > 0) {
                return 1;
            } else if (this.w - n.w == 0) {
                return 0;
            } else return -1;
        }
    }

    static List<Node>[] list;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ttc = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < ttc; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list = new List[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                list[a].add(new Node(b, d));
                list[b].add(new Node(a, d));
            }

            List<Long> ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());

                long v1Tov2 = passWithPoint(s, g, h, x);
                long v2Tov1 = passWithPoint(s, h, g, x);
                long directPass = dijkstra(s, x);

                if (directPass >= v1Tov2 || directPass >= v2Tov1) {
                    ans.add((long) x);
                }
            }

            Collections.sort(ans);

            for (int i = 0; i < ans.size(); i++) {
                sb.append(ans.get(i)).append(" ");
            }

            System.out.println(sb);
        }
    }

    static long passWithPoint(int s, int v1, int v2, int end) {
        long a = dijkstra(s, v1);
        long b = dijkstra(v1, v2);
        long c = dijkstra(v2, end);

        if (a == -1 || b == -1 || c == -1) {
            return Integer.MAX_VALUE;
        } else {
            return a + b + c;
        }
    }

    static long dijkstra(int start, int end) {
        Queue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        dist[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.e]) continue;
            visited[cur.e] = true;

            for (int i = 0; i < list[cur.e].size(); i++) {
                Node next = list[cur.e].get(i);

                if (dist[next.e] > dist[cur.e] + next.w) {
                    dist[next.e] = dist[cur.e] + next.w;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }

        if (dist[end] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[end];
        }
    }
}
