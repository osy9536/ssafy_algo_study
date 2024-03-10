package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T ; t++) {
            int N = Integer.parseInt(br.readLine());

            int [][] A = new int[2][N+1];
            int [][] D = new int[2][N+1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            D[0][1] = A[0][1];
            D[1][1] = A[1][1];
            if(N>1){
                D[0][2] = D[1][1] + A[0][2];
                D[1][2] = D[0][1] + A[1][2];
            }
            for (int i = 3; i <= N ; i++) {
                D[0][i] = Math.max(D[1][i-1],D[1][i-2]) + A[0][i];
                D[1][i] = Math.max(D[0][i-1],D[0][i-2]) + A[1][i];
            }

            int ans;
            ans = Math.max(D[0][N],D[1][N]);
//            System.out.println(ans);
            sb.append(ans).append("\n");

//            for (int i = 0; i < 2; i++) {
//                System.out.println(Arrays.toString(A[i]));
//            }
        }
        System.out.println(sb);
    }
}


