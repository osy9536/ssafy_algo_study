package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 17472
 * 다리 만들기2
 * https://www.acmicpc.net/problem/17472
 */
public class b17472 {

    static class Node implements Comparable<Node> {
        int t;
        int cost;

        public Node(int t, int cost) {
            super();
            this.t = t;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    static int n; // 행
    static int m; // 열
    static int[][] map;

    static int town = 1; //정점의 수
    static int e; //간선의 수
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //마을 개수 구하기
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] || map[i][j] != 1)
                    continue;
                findTown(i, j, town++, visited);

            }
        }

        graph = new int[town][town];

        for (int i = 1; i < town; i++) {
            for (int j = 1; j < town; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        
        makeGraph();
        prim();

    }

    public static void prim() {
        edgeNum(); //간선 수
        boolean[] visit = new boolean[town];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 0));
        int answer = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.t])
                continue;

            visit[node.t] = true;

            answer += node.cost;

            for(int i = 1; i < town; i++) {
                if(graph[node.t][i] != Integer.MAX_VALUE && !visit[i]) {
                    pq.add(new Node(i, graph[node.t][i]));
                }
            }
            
            cnt++;
        }
        if(cnt != (town -1))
            answer = -1;

        System.out.println(answer);
    }

    public static void edgeNum() {
        for(int i = 1; i < town; i++)
            for(int j = 1; j < town; j++)
                if(graph[i][j] != Integer.MAX_VALUE)
                    e++;
    }

    public static void findTown(int x, int y, int town, boolean[][] visited) {
        if(map[x][y] != 1)
            return;

        map[x][y] = town;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n
                    || ny < 0 || ny >= m)
                continue;

            if(visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            findTown(nx, ny, town, visited);
        }
    }

    public static void makeGraph() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i;
                        int ny = j;

                        while (true) {
                            nx += dx[k];
                            ny += dy[k];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                                break;

                            if(map[nx][ny] == map[i][j])
                                break;

                            if(map[nx][ny] != 0) {
                                int s = map[i][j];
                                int e = map[nx][ny];
                                int temp = (nx - i) == 0 ? Math.abs(ny - j) : Math.abs(nx - i);

                                if(temp - 1 < 2)
                                    break;

                                graph[s][e] = Math.min(graph[s][e], temp - 1);

                                break;
                            }
                        }
                    }
                }
            }
        }
    }

}
