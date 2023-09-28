package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 1194
 * 달이 차오른다, 가자.
 * 골드 1
 * https://www.acmicpc.net/problem/1194
 */
public class b1194 {

    static int n; //가로
    static int m; //세로
    static char[][] maze;
    static boolean[][][] visited; //행, 열, 열쇠 가질 수 있는 모든 경우의 수 (2^6)
    static int min = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] start = new int[2];
        maze = new char[n][m];

        for(int i = 0; i < n; i++) {
            maze[i] = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(maze[i][j] == '0') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        visited = new boolean[n][m][64];

        bfs(start[0], start[1]);

        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);

    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {r, c, 0, 0}); // 행, 열, 이동 횟수, 열쇠

        int[] cur;

        int curR, curC, curCnt, curKey;

        while(!q.isEmpty()) {

            cur = q.poll();

            curR = cur[0];
            curC = cur[1];
            curCnt = cur[2];
            curKey = cur[3];

            for(int i = 0; i < 4; i++) {
                int nr = curR + dx[i];
                int nc = curC + dy[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc][curKey]) {
                    continue;
                }

                switch(maze[nr][nc]) {
                    case '.':
                        visited[nr][nc][curKey] = true;
                        q.add(new int[] {nr, nc, curCnt + 1, curKey});
                        break;
                    case '#' :
                        break;
                    case 'a' :
                        visited[nr][nc][curKey | 1] = true;
                        q.add(new int[] {nr, nc, curCnt + 1, curKey | 1});
                        break;
                    case 'b' :
                        visited[nr][nc][curKey | (1 << 1)] = true;
                        q.add(new int[] {nr, nc, curCnt + 1, curKey | (1 << 1)});
                        break;
                    case 'c' :
                        visited[nr][nc][curKey | (1 << 2)] = true;
                        q.add(new int[] {nr, nc, curCnt + 1, curKey | (1 << 2)});
                        break;
                    case 'd' :
                        visited[nr][nc][curKey | (1 << 3)] = true;
                        q.add(new int[] {nr, nc, curCnt + 1, curKey | (1 << 3)});
                        break;
                    case 'e' :
                        visited[nr][nc][curKey | (1 << 4)] = true;
                        q.add(new int[] {nr, nc, curCnt + 1, curKey | (1 << 4)});
                        break;
                    case 'f' :
                        visited[nr][nc][curKey | (1 << 5)] = true;
                        q.add(new int[] {nr, nc, curCnt + 1, curKey | (1 << 5)});
                        break;
                    case 'A' :
                        if((curKey & 1) == 1) {
                            visited[nr][nc][curKey] = true;
                            q.add(new int[] {nr, nc, curCnt + 1, curKey});
                        }
                        break;
                    case 'B' :
                        if((curKey & (1 << 1)) == 2) {
                            visited[nr][nc][curKey] = true;
                            q.add(new int[] {nr, nc, curCnt + 1, curKey});
                        }
                        break;
                    case 'C' :
                        if((curKey & (1 << 2)) == 4) {
                            visited[nr][nc][curKey] = true;
                            q.add(new int[] {nr, nc, curCnt + 1, curKey});
                        }
                        break;
                    case 'D' :
                        if((curKey & (1 << 3)) == 8) {
                            visited[nr][nc][curKey] = true;
                            q.add(new int[] {nr, nc, curCnt + 1, curKey});
                        }
                        break;
                    case 'E' :
                        if((curKey & (1 << 4)) == 16) {
                            visited[nr][nc][curKey] = true;
                            q.add(new int[] {nr, nc, curCnt + 1, curKey});
                        }
                        break;
                    case 'F' :
                        if((curKey & (1 << 5)) == 32) {
                            visited[nr][nc][curKey] = true;
                            q.add(new int[] {nr, nc, curCnt + 1, curKey});
                        }
                        break;
                    case '0':
                        visited[nr][nc][curKey] = true;
                        q.add(new int[] {nr, nc, curCnt + 1, curKey});
                        break;
                    case '1' :
                        min = Math.min(curCnt + 1, min);
                        return;

                }
            }

        }
    }
}
