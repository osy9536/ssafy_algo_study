package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N+1];
        int [] D = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        D[0] = 0;
        D[1] = A[1];

        int mx = D[1];
        for (int i = 1; i <= N; i++) {
            D[i] = Math.max(A[i],D[i-1]+A[i]);
            mx = Math.max(mx,D[i]);
        }
        System.out.println(mx);
    }

}
