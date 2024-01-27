package ohseyoung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소비용 구하기
// gold 5
public class b1916 {

    static class Node implements Comparable<Node> {
        int e;
        int w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }

    }
    
    static int N, M;
    static ArrayList<ArrayList<Node>> a;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        a = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(startPos, endPos) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.e;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.e] && dist[node.e] > dist[cur] + node.w) {
                        dist[node.e] = dist[cur] + node.w;
                        pq.add(new Node(node.e, dist[node.e]));
                    }
                }
            }
        }
        return dist[e];
    }
}
