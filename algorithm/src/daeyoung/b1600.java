package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1600
 * 말이 되고픈 원숭이
 * 골드 3
 * https://www.acmicpc.net/problem/1600
 */
public class b1600 {

    static int k; // 말로 움직일 수 있는 횟수
    static int w; // 가로, 열
    static int h; // 세로, 행
    static int[][] map;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;

    static int[] hr = {-2, -1 ,-2, -1, 1, 2, 1, 2}; // 말의 행 움직임
    static int[] hc = {-1, -2, 1, 2, -2, -1, 2, 1}; // 말의 열 움직임
    static int[] mr = {-1, 0, 1, 0}; // 원숭이의 행 움직임
    static int[] mc = {0, -1, 0, 1}; // 원숭이의 열 음직임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[h][w][k + 1];

        bfs(0, 0, 0, 0);

        if(min == Integer.MAX_VALUE)
            min = -1;
        System.out.println(min);
    }

    // 행, 열, 이동 횟수, 말 움직임 횟수
    public static void bfs(int r, int c, int cnt, int horse) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {r, c, cnt, horse});
        visited[r][c][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == h - 1 && cur[1] == w - 1) {
                min = Math.min(min, cur[2]);
                continue;
            }

            //원숭이의 움직임
            for (int i = 0; i < 4; i++) {
                int tempR = cur[0] + mr[i];
                int tempC = cur[1] + mc[i];

                if(tempR < h && tempR >= 0
                        && tempC < w && tempC >= 0 && map[tempR][tempC] != 1 && !visited[tempR][tempC][cur[3]]) {
                    visited[tempR][tempC][cur[3]] = true;
                    q.add(new int[] {tempR, tempC, cur[2] + 1, cur[3]});
                }
            }

            if(cur[3] < k) {
                //말의 움직임
                for (int i = 0; i < 8; i++) {
                    int tempR = cur[0] + hr[i];
                    int tempC = cur[1] + hc[i];

                    if(tempR < h && tempR >= 0
                            && tempC < w && tempC >= 0 && map[tempR][tempC] != 1 && !visited[tempR][tempC][cur[3] + 1]) {
                        visited[tempR][tempC][cur[3] + 1] = true;
                        q.add(new int[] {tempR, tempC, cur[2] + 1, cur[3] + 1});
                    }
                }
            }


        }
    }
}
