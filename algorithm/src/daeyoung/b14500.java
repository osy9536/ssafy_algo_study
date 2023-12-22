package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 14500
 * 테트로미노
 * 골드 4
 * https://www.acmicpc.net/problem/14500
 */
public class b14500 {
    static int n; //행
    static int m; //열
    static int[][] plate;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        plate = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int x, int y, int cnt, int sum) {
        if(cnt == 3) {
            boolean rowConnect = true;
            boolean colConnect = true;

            //세로로 연속
            if(x < n - 2) {
                for (int i = x; i <= x + 2; i++) {
                    if(!visited[i][y]) {
                        rowConnect = false;
                        break;
                    }
                }

                if(rowConnect) {
                    if(y + 1 < m) {
                        answer = Math.max(answer, sum + plate[x + 1][y + 1]);
                    }

                    if(y - 1 >= 0) {
                        answer = Math.max(answer, sum + plate[x + 1][y - 1]);
                    }


                }
            }

            //가로로 연속
            if(y < m - 2) {

                for (int i = y; i <= y + 2; i++) {
                    if(!visited[x][i]) {
                        colConnect = false;
                        break;
                    }
                }

                if(colConnect) {
                    if(x + 1 < n) {
                        answer = Math.max(answer, sum + plate[x + 1][y + 1]);
                    }

                    if(x - 1 >= 0) {
                        answer = Math.max(answer, sum + plate[x - 1][y + 1]);
                    }
                }
            }
        }

        if(cnt == 4) {

            answer = Math.max(answer, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, sum + plate[nx][ny]);
                visited[nx][ny] = false;
            }

        }

    }
}
