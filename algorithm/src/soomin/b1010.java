package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1010 {
    static int N,M;
    static int [][] link;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int TC = 0; TC < T; TC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            link = new int[M+1][M+1];

            out:
            for (int i = 1; i <= M; i++) {
                for (int j = 0; j <= M; j++) {
                    if(j == 0 || i == j) {
                        link[i][j] = 1;
                    }
                    else link[i][j] = link[i-1][j-1] + link[i-1][j];

                    if(link[M][N] != 0) {
                        break out;
                    }
                }
            }

            System.out.println(link[M][N]);

        }
    }
}
