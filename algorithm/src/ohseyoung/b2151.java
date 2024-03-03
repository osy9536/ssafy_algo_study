import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 거울 설치
// gold 3
public class Main {

    static class Node implements Comparable<Node> {
        int x, y, num, dir;

        public Node(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }

        public int compareTo(Node n) {
            return Integer.compare(this.num, n.num);
        }
    }

    static char[][] map;
    static int doorX, doorY;
    static int n, mirrorNum;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        int door = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);

                if (c == '#') {
                    doorX = i;
                    doorY = j;
                }

                map[i][j] = c;
            }
        }

        ans = Integer.MAX_VALUE;
        map[doorX][doorY] = '.';
        for (int i = 0; i < 4; i++) {
            int nx = doorX + dx[i];
            int ny = doorY + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny]!='*') {
                if (map[nx][ny] == '#') {
                    ans = 0;
                    break;
                }
                if (map[nx][ny] == '!') {
                    bfs(nx,ny,(4 + (i + 1)) % 4);
                    bfs(nx,ny,(4 + (i - 1)) % 4);
                }
                bfs(nx, ny, i);
            }
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y, int dir) {

        Queue<Node> pq = new PriorityQueue<>();
        int a = 0;
        if(map[x][y]=='!'){
            int px = x + dx[(dir+2)%4];
            int py = y + dy[(dir+2)%4];
            if (px >= 0 && py >= 0 && px < n && py < n) {
                if (px == doorX && py == doorY) {
                    a--;
                }
            }
            a++;
        }
        pq.add(new Node(x, y, a, dir));

        int[][] visited = new int[n + 1][n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

//            if (visited[cur.x][cur.y] < 3) {
//                visited[cur.x][cur.y]++;
//            } else {
//                continue;
//            }
            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if (map[nx][ny]=='#') {
                ans = Math.min(ans, cur.num);
                return;
            }

            if (map[nx][ny] == '.' || map[nx][ny] == '!') {
                pq.add(new Node(nx, ny, cur.num, cur.dir));
            }

            if (map[nx][ny] == '!') {
                pq.add(new Node(nx, ny, cur.num + 1, (4 + (cur.dir + 1)) % 4));
                pq.add(new Node(nx, ny, cur.num + 1, (4 + (cur.dir - 1)) % 4));
            }
        }
    }
}
