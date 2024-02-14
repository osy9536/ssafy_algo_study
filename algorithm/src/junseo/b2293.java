package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] A = new int[N+1];
        int [] D = new int[K+1];
        for (int i = 1; i <= N ; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        D[0] = 1;

        for (int i = 1; i <= N ; i++) {
            for (int j = A[i]; j <= K ; j++) {
                D[j] = D[j] + D[j-A[i]];
            }
        }
        System.out.println(D[K]);
    }
}

