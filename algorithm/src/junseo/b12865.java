package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N,K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] D = new int[N+1][K+1];
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if(W[j] > i) {
                    D[j][i] = D[j-1][i];
                }
                else{
                    D[j][i] = Math.max(D[j-1][i], D[j-1][i-W[j]] + V[j]);
                }
            }
        }
        System.out.println(D[N][K]);
        
    }
}

