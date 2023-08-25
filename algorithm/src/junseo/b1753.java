package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1753 {
    static int V,E,K;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        dist = new int[V+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,weight));
        }
        dijkstra();
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        queue.add(new Node(K,0));
        dist[K] = 0;

        while (!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;
            if(check[cur]) continue;
            check[cur] = true;

            for (Node node:list[cur]) {
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end,dist[node.end]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int end,weight;

        public Node(int end,int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}

