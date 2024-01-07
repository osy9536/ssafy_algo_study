import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int [] A = new int[N];
        int [] L = new int[N];
        int [] R = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        /*
        D[i]는 i번째 수를 포함한 수중 가장 큰 값
        max(D[i-1] + A[i],A[i])
        i-1번째 수를 포함한 max+ i번째 수 or
        i번째 수
         */

        L[0] = A[0];
        int mx = L[0];
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(L[i-1]+A[i],A[i]);
            mx = Math.max(L[i],mx);
        }

        R[N-1] = A[N-1];
        for (int i = N-2; i >= 0 ; i--) {
            R[i] = Math.max(R[i+1]+A[i],A[i]);
        }

        for (int i = 1; i < N-1; i++) {
            mx = Math.max(mx,L[i-1]+R[i+1]);
        }

        System.out.println(mx);
    }

}
