package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 4485
 * 녹색 옷을 입은 애가 젤다지?
 * 골드 4
 * https://www.acmicpc.net/problem/4485
 */
public class b4485 {

    static int num;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = 1;
        while((num = Integer.parseInt(st.nextToken())) != 0) {
            map = new int[num][num];
            dp = new int[num][num];

            for(int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < num; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0);

            sb.append("Problem ").append(p++).append(": ")
                    .append(dp[num - 1][num - 1]).append("\n");
            st = new StringTokenizer(br.readLine());
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        dp[x][y] = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            x = cur[0];
            y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= num || ny < 0 || ny >= num)
                    continue;

                if(dp[x][y] + map[nx][ny] >= dp[nx][ny])
                    continue;

                dp[nx][ny] = dp[x][y] + map[nx][ny];
                q.add(new int[]{nx, ny});
            }

        }
    }
}
