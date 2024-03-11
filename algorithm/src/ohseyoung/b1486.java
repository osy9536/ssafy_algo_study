import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int r, c, d;
    public Node(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

// 등산
// gold 2
public class b1486 {
    private static StringTokenizer st;
    private static int r,c,t,d;
    private static int[][] map;
    private static int DIST_LIMIT = 52*52*25*25+1;

    private static int solution(int[][] a, int[][] b) {
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] + b[i][j] > d)  continue;
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }

    private static int getGap(int a, int b) {
        if (Math.abs(a-b) > t) return -1;
        if (a >= b) return 1;
        return (b-a) * (b-a);
    }

    private static int[][] f(boolean reverse) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.d - o2.d;
            }
        });
        int[][] dist = new int[r][c];
        boolean[][] v = new boolean[r][c];

        for (int[] row : dist) Arrays.fill(row, DIST_LIMIT);
        pq.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cr = cur.r;
            int cc = cur.c;
            int cd = cur.d;

            if (v[cr][cc]) continue;
            v[cr][cc] = true;

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (((dr^dc)&1) != 1) continue;
                    int nr = cr + dr;
                    int nc = cc + dc;
                    if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                    int gap = !reverse ? getGap(map[cr][cc], map[nr][nc]) : getGap(map[nr][nc], map[cr][cc]);
                    if (gap == -1 || dist[nr][nc] < cd+gap) continue;

                    dist[nr][nc] = cd+gap;
                    pq.add(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }
        return dist;
    }

    private static int ni() { return Integer.parseInt(st.nextToken()); }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r=ni(); c=ni(); t=ni(); d=ni();
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char tmp = row.charAt(j);
                map[i][j] = tmp >= 'a' ? tmp - 'a' + 26 : tmp - 'A';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        int answer = solution(f(false), f(true));
        System.out.println(answer);
    }
}

//import java.io.*;
//import java.util.*;
//
//// 등산
//// gold 2
//class Main {
//
//    static class Node implements Comparable<Node> {
//        int x, y, h, time, maxH;
//
//        public Node(int x, int y, int h, int time, int maxH) {
//            this.x = x;
//            this.y = y;
//            this.h = h;
//            this.time = time;
//            this.maxH = maxH;
//        }
//
//        public int compareTo(Node node) {
//            return node.maxH - this.maxH;
//        }
//    }
//
//    static int n, m, t, d, ans;
//    static int[][] map;
//    static int[] dx = {-1, 0, 1, 0};
//    static int[] dy = {0, 1, 0, -1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken()); // 산의 세로 < 25
//        m = Integer.parseInt(st.nextToken()); // 산의 가로 < 25
//        t = Integer.parseInt(st.nextToken()); // 세준이는 높이의 차이가 T보다 크지 않아야 이동 가능 < 52
//        d = Integer.parseInt(st.nextToken()); // 어두워지는 시간, 어두워지기 전에 호텔 가야함 < 1,000,000
//
//        map = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            String s = br.readLine();
//            for (int j = 0; j < s.length(); j++) {
//                char c = s.charAt(j);
//
//                if (c >= 'a' && c <= 'z') {
//                    map[i][j] = c - 'a' + 26;
//                } else if (c >= 'A' && c <= 'Z') {
//                    map[i][j] = c - 'A';
//                }
//            }
//        }
//
//        solved();
//        System.out.println(ans);
//    }
//
//    static void solved() {
//
//        Queue<Node> pq = new PriorityQueue<>();
//        pq.add(new Node(0, 0, map[0][0], 0,0));
//
//        boolean[][][][] visited = new boolean[d+1][52][n][m];
//        visited[0][0][0][0] = true;
//
//        while (!pq.isEmpty()) {
//
//            Node cur = pq.poll();
//
////            System.out.println("x : " + cur.x + ". y : " + cur.y + ", height : " + cur.h + ", time : " + cur.time + ", maxH : " + cur.maxH);
//            if (cur.time != 0 && cur.x == 0 && cur.y == 0) {
//                ans = Math.max(ans, cur.maxH);
//            }
//
//            for (int i = 0; i < 4; i++) {
//
//                int nx = cur.x + dx[i];
//                int ny = cur.y + dy[i];
//
//                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
//
//                // 높이의 차이 계산, t보다 크면 안됨
//                if (Math.abs(map[nx][ny] - cur.h) > t) {
//                    continue;
//                }
//
//                // 높이 차이에 대한 시간 계산, 어두워 지면 취소
//                int time = 0;
//                if (cur.h < map[nx][ny]) {
//                    time = (int) Math.pow(map[nx][ny]-cur.h,2);
//                }
//                if (cur.h > map[nx][ny]) {
//                    time = 1;
//                }
//                if (cur.time + time > d) {
//                    continue;
//                }
//
//                if(visited[cur.time+time][Math.max(map[nx][ny], cur.maxH)][nx][ny])continue;
//                visited[cur.time + time][Math.max(map[nx][ny], cur.maxH)][nx][ny] = true;
//
//                pq.add(new Node(nx, ny, map[nx][ny], cur.time+time, Math.max(map[nx][ny], cur.maxH)));
//            }
//        }
//    }
//}
