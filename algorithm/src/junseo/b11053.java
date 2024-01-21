package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N;
        N = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        int [] D = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N; i++) {
            D[i] = 1;

            for (int j = 0; j < i; j++) {
                if(A[j]<A[i] && D[i] < D[j]+1){
                    D[i] = D[j] + 1;
                }

            }
        }

        int max  = 0;
        for (int i = 0; i < N ; i++) {
            max = Math.max(max,D[i]);
        }
        System.out.println(max);

    }
}

