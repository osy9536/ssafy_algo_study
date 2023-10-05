package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, W, H, answer;
    static int[][] map, copyMap, origin;
    static int[] selected;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            origin = new int[H][W];
            selected = new int[N];
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    map[i][j] = a;
                    origin[i][j] = a;
                }
            }

            permu(0);
            System.out.println("#" + tc + " " + answer);
        }
    }

    static void permu(int depth) {
        if (depth == N) {
            copyMap = deepCopy(map);
            for (int i = 0; i < N; i++) {
                int a = selected[i];
                func(a); // 구슬 치기 이후 벽돌 제거
                fill(); // 벽돌 제거 이후 아래부터 빈공간 채우기
            }
            answer = Math.min(answer, findNum());
            return;
        }

        for (int i = 0; i < W; i++) {
            selected[depth] = i;
            permu(depth + 1);
        }
    }

    private static int findNum() {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copyMap[i][j] != 0)
                    cnt++;
            }
        }
        return cnt;
    }

    private static void fill() {
        for (int j = 0; j < W; j++) {
            int nonZeroCnt = 0;
            for (int i = H - 1; i >= 0; i--) {
                if (copyMap[i][j] != 0) {
                    int temp = copyMap[i][j];
                    copyMap[i][j] = 0;
                    copyMap[H - 1 - nonZeroCnt][j] = temp;
                    nonZeroCnt++;
                }
            }
        }
    }

    private static void func(int a) {
        for (int i = 0; i < H; i++) {
            if (copyMap[i][a] != 0) {
                dfs(i, a);
                fill();
                break;
            }
        }
    }

    private static void dfs(int x, int y) {
        int value = copyMap[x][y];
        copyMap[x][y] = 0;
        if (value <= 1) {
            return;
        }
        for (int d = 0; d < 4; d++) {
            for (int k = 1; k < value; k++) {
                int nx = x + dx[d] * k;
                int ny = y + dy[d] * k;
                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                    if (copyMap[nx][ny] > 1) {
                        dfs(nx, ny);
                    } else if (copyMap[nx][ny] == 1) {
                        copyMap[nx][ny] = 0;
                    }
                }
            }
        }
    }

    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
}
