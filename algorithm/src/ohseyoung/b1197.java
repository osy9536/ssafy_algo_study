package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 최소 스패닝 트리
// gold 4
public class b1197 {
    static class Node implements Comparable<Node> {
        int end, w;

        Node(int end, int w) {
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }

    }

    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int answer = 0;
        list = new ArrayList[V+1];
        visited = new boolean[V+1];
        for(int i = 1; i<=V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a, c));
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(1,0));
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int to = cur.end;
            int w = cur.w;
            if(visited[to]) continue;
            visited[to] = true;
            answer +=w;
            for (Node next : list[to]) {
                if (!visited[next.end]) {
                    q.add(next);
                }
            }
        }

        System.out.println(answer);
    }

}
