package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][]D = new int[3][N+1];

        D[0][1] = 1;
        D[1][1] = 1;
        D[2][1] = 1;
        for (int i = 2; i <= N; i++) {
            D[0][i] = (D[0][i-1] + D[1][i-1] + D[2][i-1])% 9901;
            D[1][i] = (D[0][i-1] + D[2][i-1])% 9901;
            D[2][i] = (D[0][i-1] + D[1][i-1]) % 9901;
        }

        System.out.println((D[0][N] + D[1][N] + D[2][N])%9901);
    }
}

