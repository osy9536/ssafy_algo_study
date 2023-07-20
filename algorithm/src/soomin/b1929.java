package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1929 {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            boolean [] bb = new boolean[N+1];
            bb[1] = bb[0] = true;

        for (int i = 2; i < Math.sqrt(N+1); i++) {
            for (int j = i*i; j < N+1; j+=i) {
                bb[j] = true;
            }
        }

        for (int i = M; i < N+1; i++) {
            if(!bb[i]){
                System.out.println(i);
            }
        }

    }
}

