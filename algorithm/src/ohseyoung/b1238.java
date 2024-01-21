package algorithm.src.ohseyoung;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 파티
// gold 3
class b1238 {
    static final int INF = 987654321;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static ArrayList<ArrayList<Node>> arrList, reverseArrList;
    static int N, X;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arrList = initializeArrayList(N);
        reverseArrList = initializeArrayList(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arrList.get(start).add(new Node(end, weight));
            reverseArrList.get(end).add(new Node(start, weight));
        }

        int[] dist1 = dijkstra(arrList);
        int[] dist2 = dijkstra(reverseArrList);

        int ans = calculateMaxDistance(dist1, dist2);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static ArrayList<ArrayList<Node>> initializeArrayList(int size) {
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            list.add(new ArrayList<>());
        }
        return list;
    }

    static int[] dijkstra(ArrayList<ArrayList<Node>> a) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Node curTown = pq.poll();
            int cur = curTown.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node town : a.get(cur)) {
                    if (!check[town.end] && dist[town.end] > dist[cur] + town.weight) {
                        dist[town.end] = dist[cur] + town.weight;
                        pq.add(new Node(town.end, dist[town.end]));
                    }
                }
            }
        }
        return dist;
    }

    static int calculateMaxDistance(int[] dist1, int[] dist2) {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }
        return ans;
    }
}
