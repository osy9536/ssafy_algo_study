package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4948 {
    // true -> 소수가 아님, false -> 소수
    static boolean [] flag ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            flag = new boolean[2*N + 1];

            flag[0] = true;
            flag[1] = true;

            for (int i = 2; i < Math.sqrt(2*N+1); i++) {
                for (int j = i*i; j < 2*N+1; j+=i) {
                    if(flag[j]) continue;
                    flag[j] = true;
                }
            }

            for (int i = N+1; i < 2*N+1; i++) {
                if(!flag[i]) cnt ++;
            }

            System.out.println(cnt);

        }
    }
}
