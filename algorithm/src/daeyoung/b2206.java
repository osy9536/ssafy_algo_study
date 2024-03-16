package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 2206
 * 벽 부수고 이동하기
 * 골드 3
 * https://www.acmicpc.net/problem/2206
 */
public class b2206 {

    static int n;
    static int m;
    static char[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int min = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];

        //row, col, 벽 부순 횟수
        q.add(new int[] {0, 0, 1, 0});
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == n - 1 && cur[1] == m - 1) {
                min = cur[2];
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dx[i];
                int nc = cur[1] + dy[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if(visited[nr][nc][cur[3]])
                    continue;

                if(map[nr][nc] == '1' && cur[3] > 0)
                    continue;

                if(map[nr][nc] == '1' && cur[3] == 0) {
                    visited[nr][nc][1] = true;
                    q.add(new int[] {nr, nc, cur[2] + 1, 1});
                } else {
                    visited[nr][nc][cur[3]] = true;
                    q.add(new int[] {nr, nc, cur[2] + 1, cur[3]});
                }

            }
        }

        if(min == Integer.MAX_VALUE)
            return -1;

        return min;
    }
}
