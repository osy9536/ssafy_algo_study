package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1932 {
    static int[][]A;
    static Integer [][] D;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        A = new int[N+1][N+1];
        D = new Integer[N+1][N+1];

        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i+1 ; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i<=N ; i++) {
            D[N][i] = A[N][i];
        }
        
        find(1,1);

        System.out.println(D[1][1]);

    }

    private static int find(int depth, int idx) {
        if(depth == N) return D[depth][idx];

        if(D[depth][idx] == null){
            D[depth][idx]= Math.max(find(depth+1,idx),find(depth+1,idx+1)) + A[depth][idx];
        }

        return D[depth][idx];

    }

}

