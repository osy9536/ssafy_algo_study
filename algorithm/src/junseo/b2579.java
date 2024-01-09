package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] D = new int[N+1];
        int [] A = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        D[1] = A[1];
        if(N>1){
            D[2] = D[1] + A[2];
        }

        for (int i = 3; i <= N; i++) {
            D[i] = Math.max(D[i-3] + A[i-1] + A[i],D[i-2] + A[i]);
        }
        System.out.println(D[N]);
    }
}

