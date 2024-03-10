package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int [] D = new int[N+1];
        int [] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        D[1] = A[1];
        for (int i = 2; i <= N; i++) {
            D[i] = Math.max(D[i-1] + D[1] , A[i]);
            for (int j = 2; j <= i/2 ; j++) {
                D[i] = Math.max(D[i],D[i-j] + D[j]);
            }
        }
        System.out.println(D[N]);

    }
}


