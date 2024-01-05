package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 알고스팟
// gold4
public class b1261 {

    static class Node implements Comparable<Node> {
        int x, y, w;

        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static boolean[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, ans, cnt;
    static boolean[][][] visited; // 3차원 배열로 변경

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new boolean[n][m][n * m + 1]; // 경로 수 만큼 확장

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                boolean a = s.charAt(j) == '1';
                map[i][j] = a;
            }
        }

        Dijkstra();

        System.out.println(ans);
    }

    private static void Dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                ans = cur.w;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny][cur.w]) continue;
                visited[nx][ny][cur.w] = true;

                if (map[nx][ny]) {
                    pq.add(new Node(nx, ny, cur.w + 1));
                } else {
                    pq.add(new Node(nx, ny, cur.w));
                }
            }
        }
    }
}
