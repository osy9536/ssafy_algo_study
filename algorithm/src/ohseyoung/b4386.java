package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 별자리 만들기
// gold 3
public class b4386 {

    static class Node {
        double x, y;
        int num;

        Node(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static class Dis implements Comparable<Dis> {
        int start, end;
        double w;

        Dis(int s, int e, double w) {
            start = s;
            end = e;
            this.w = w;
        }

        @Override
        public int compareTo(Dis o) {
            if(this.w<o.w) return -1;
            return 1;
        }
    }

    static Node[] positions;
    static boolean[] visited;
    static int n;
    static double ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        positions = new Node[n];
        visited = new boolean[n];
        ans = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            positions[i] = new Node(i, x, y);
        }
        find();
        System.out.println(Math.round(ans*100)/100.0);
    }

    static void find() {
        Queue<Dis> q = new PriorityQueue<>();
        Node start = positions[0];
        for (int i = 1; i < n; i++) {
            double dis = distance(start, positions[i]);
            q.add(new Dis(0, i,dis));
        }
        visited[0] = true;

        while (!q.isEmpty()) {
            Dis cur = q.poll();
            if(visited[cur.end]) continue;
            visited[cur.end] = true;
            ans += cur.w;

            for (int i = 0; i < n; i++) {
                if(visited[i]) continue;
                double dis = distance(positions[cur.end], positions[i]);
                q.add(new Dis(cur.end, i, dis));
            }

        }
    }

    static double distance(Node n1, Node n2) {
        double x1 = n1.x;
        double y1 = n1.y;
        double x2 = n2.x;
        double y2 = n2.y;

        double dis = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));

        return dis;
    }
}
