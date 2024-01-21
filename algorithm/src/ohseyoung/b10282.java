
import java.io.*;
import java.util.*;

// 해킹
// gold 4
class b10282 {

    static class Node implements Comparable<Node>{
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

    static int n, cnt, ans;
    static int[] dist;
    static List<Node>[] list;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            cnt = 0;
            ans = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list = new List[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Node(a,s));
            }

            dijkstra(c);

            System.out.println(cnt+" "+ans);
        }
    }

    private static void dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            cnt++;
            ans = cur.w;

            for (int i = 0; i < list[cur.e].size(); i++) {
                Node next = list[cur.e].get(i);

                if (dist[next.e] > dist[cur.e] + next.w) {
                    dist[next.e] = dist[cur.e] + next.w;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }
    }
}
