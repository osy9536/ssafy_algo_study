package algorithm.src.ohseyoung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 택배
// gold 3
public class b1719 {

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

    static int n, m;
    static List<Node>[] lists;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lists = new List[n + 1];
        ans = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            lists[a].add(new Node(b, l));
            lists[b].add(new Node(a, l));
        }

        for (int i = 1; i < n + 1; i++) {
            dijkstra(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    sb.append("- ");
                    continue;
                }
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.e]) {
                visited[cur.e] = true;

                for (Node node : lists[cur.e]) {
                    if (!visited[node.e] && dist[node.e] > node.w + cur.w) {
                        dist[node.e] = node.w + cur.w;
                        ans[node.e][start]=cur.e;
                        pq.add(new Node(node.e, dist[node.e]));
                    }
                }
            }
        }
    }
}
