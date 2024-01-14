import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 벽 부수고 이동하기 4
// gold 2
public class Main {

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map, copy;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int n, m;
    static List<Node> nodes;
    static int[][] groups;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copy = new int[n][m];
        visited = new boolean[n][m];
        groups = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                int a = s.charAt(j) - '0';
                map[i][j] = a;
                if (a == 1) copy[i][j] = -1;
                else copy[i][j] = a;
            }
        }
        int group = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    if (visited[i][j]) continue;
                    visited[i][j] = true;
                    nodes = new ArrayList<>();
                    int a = findNum(i, j);
                    for (int k = 0; k < nodes.size(); k++) {
                        Node node = nodes.get(k);
                        groups[node.x][node.y] = group;
                        copy[node.x][node.y] = a;
                    }
                    group++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    boolean[] check = new boolean[group];
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (copy[nx][ny] == -1) continue;
                        if (check[groups[nx][ny]]) continue;
                        check[groups[nx][ny]] = true;
                        int sum = copy[nx][ny];
                        map[i][j] += sum;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]%10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int findNum(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        int sum = 0;
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            nodes.add(cur);
            sum++;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != 0) continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
        return sum;
    }
}
