package algorithm.src.ohseyoung;

import java.io.*;
import java.util.StringTokenizer;

// 내리막길
// gold 3
public class b1520 {
    static int M, N;
    static int[][] arr, dp;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = -1;
            }
        }

        bw.write(DFS(1, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int DFS(int x, int y) {
        if (x == M && y == N) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || ny < 1 || nx > M || ny > N) {
                continue;
            }
            if (arr[x][y] > arr[nx][ny]) {
                dp[x][y] += DFS(nx, ny);
            }
        }

        return dp[x][y];
    }

}
