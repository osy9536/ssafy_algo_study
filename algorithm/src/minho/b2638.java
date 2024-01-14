package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class XY {
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class b2638 {

    static int N, M, count=0;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] isVisited;
    static int[][] check;
    static boolean isEnd;

    static void BFS() {
        isVisited = new boolean[N][M];
        Queue<XY> q = new ArrayDeque<>();
        q.add(new XY(0, 0));
        isVisited[0][0] = true;
        check = new int[N][M];

        while (!q.isEmpty()) {
            XY xy = q.poll();
            for (int d = 0; d < 4; d++) {
                int xd = dx[d] + xy.x;
                int yd = dy[d] + xy.y;
                if (xd >= N || xd < 0 || yd < 0 || yd >= M) continue;
                if (isVisited[xd][yd]) continue;
                if(map[xd][yd] == 1){
                    check[xd][yd]++;
                    continue;
                }
                isVisited[xd][yd] = true;
                map[xd][yd] = 2;
                q.add(new XY(xd, yd));
            }
        }

        isEnd = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(check[i][j]>=2){
                    map[i][j] =0;
                }
                if(isEnd && map[i][j]==1){
                    isEnd = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(!isEnd){
            BFS();
            count++;
        }

        System.out.println(count);
    }
}