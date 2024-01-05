package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 14466
 * 소가 길을 건너간 이유6
 * 골드 4
 * https://www.acmicpc.net/problem/14466
 */
public class b14466 {

    static boolean[][][] path;
    static int[][] cow;
    static int n; //농장 길이
    static int k; //소의 수
    static int r; //길의 수

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        path = new boolean[n + 1][n + 1][4];

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for(int j = 0; j < 4; j++) {
                int nr = r1 + dx[j];
                int nc = c1 + dy[j];

                if(nr == r2 && nc == c2)
                    path[r1][c1][j] = true;
            }

            for(int j = 0; j < 4; j++) {
                int nr = r2 + dx[j];
                int nc = c2 + dy[j];

                if(nr == r1 && nc == c1)
                    path[r2][c2][j] = true;
            }
        }

        cow = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < k; i++) {
            for(int j = i + 1; j < k; j++) {
                //길없이 건널 수있는지 확인하자
                if (bfs(cow[i][0], cow[i][1], cow[j][0], cow[j][1]))
                    continue;

                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean bfs(int sr, int sc, int er, int ec) {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            //왼 아래 오른 위
            for (int i = 0; i < 4; i++) {

                //길이 있는지 확인
                if(path[cur[0]][cur[1]][i])
                    continue;

                int nr = cur[0] + dx[i];
                int nc = cur[1] + dy[i];

                if(nr > n || nr < 1 || nc > n || nc < 1 || visited[nr][nc])
                    continue;

                if(nr == er && nc == ec)
                    return true;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return false;
    }

}
