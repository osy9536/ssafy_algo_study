package algorithm.src.minho;

import java.util.Arrays;
import java.util.Scanner;

public class b2448 {
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new char[N][N * 2 - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }

        star(0, N-1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void star(int r, int c, int N) {
        if (N == 3) {
            arr[r][c] = '*';
            arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
            arr[r + 2][c - 2] = arr[r + 2][c - 1] = arr[r + 2][c] = arr[r + 2][c + 1] = arr[r + 2][c + 2] = '*';
            return;
        } else {
            int cut = N / 2;
            star(r, c, cut);
            star(r + cut, c - cut, cut);
            star(r + cut, c + cut, cut);
        }
    }
}