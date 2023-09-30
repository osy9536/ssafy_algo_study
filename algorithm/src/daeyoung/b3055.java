package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 3055
 * 탈출
 * 골드 4
 * https://www.acmicpc.net/problem/3055
 */
public class b3055 {

    static int r;
    static int c;
    static char[][] map;
    static Queue<int[]> water = new LinkedList<>();
    static int min = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int sr = -1;
        int sc = -1;
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 'S') {
                    sr = i;
                    sc = j;
                } else if(map[i][j] == '*')
                    water.add(new int[] {i, j});
            }
        }

        //고슴도치 이동
        bfs(sr, sc);

        if(min == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(min);
        }


    }

    public static void bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {sr, sc, 0}); // 행, 열, 이동 횟수

        while (!q.isEmpty()) {

           //물 이동
            int wateSize = water.size();
            for(int i = 0; i < wateSize; i++) {
                int[] temp = water.poll();
                int x = temp[0];
                int y = temp[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        water.add(new int[] {nx,ny});
                    }
                }
            }

            //고듬도치 이동
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                int cnt = temp[2];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if(map[nx][ny] == 'D'){
                            min = Math.min(min, cnt + 1);
                            return;
                        } else if(map[nx][ny] == '.'){
                            map[nx][ny] = 'S';
                            q.add(new int[] {nx, ny, cnt + 1});
                        }
                    }
                }
            }

        }


    }
}
/*
미리 큐 사이즈를 지정해 놓고 반복문 돌려야함 -> 왜냐면 반복문 돌리면서 큐의 크기가 변하기 때문에!
 */
