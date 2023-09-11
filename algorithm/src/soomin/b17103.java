package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b17103 {

    static boolean [] flag;

    static int N, T;

    static int sum = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cnt=0;
            N = Integer.parseInt(br.readLine());
            flag = new boolean[N+1];

            flag[0] = flag[1] = true;

            for (int j = 2; j <= Math.sqrt(N); j++) {
                for (int k = j*j; k <= N; k+=j) {
                    if(flag[k]) continue;
                    flag[k] = true;
                }
            }


            for (int j = 2; j <= N/2; j++) {
                if(!flag[j]){
                    if(!flag[N-j]){
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }
}
