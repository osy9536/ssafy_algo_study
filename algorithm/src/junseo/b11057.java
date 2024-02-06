package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] D = new int[N+1][10];
        for (int i = 0; i < 10; i++) {
            D[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k >= 0 ; k--) {
                    D[i][j] += D[i-1][k];
                }
                D[i][j] = D[i][j] % 10007;
            }
        }
        int ans = 0;
        for (int i = 0; i < 10 ; i++) {
            ans += D[N][i];
        }
        ans %= 10007;
        System.out.println(ans);
    }
}

