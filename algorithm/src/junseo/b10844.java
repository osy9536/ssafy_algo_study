package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] D = new int[N+1][10]; // D[N][H] 길이가 N인 계단에서 H로 끝나는 층을 만들 수 있는 경우의 수

        D[1][0] = 0;
        for (int i = 1; i <10; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10 ; j++) {
                if(j == 0){
                    D[i][j] = D[i-1][j+1];
                }
                else if (j == 9) {
                    D[i][j] = D[i-1][j-1];
                }
                else {
                    D[i][j] = (D[i-1][j-1] + D[i-1][j+1])  % 1_000_000_000;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += D[N][i];
            ans %= 1_000_000_000;
        }
        System.out.println(ans);
    }

}

