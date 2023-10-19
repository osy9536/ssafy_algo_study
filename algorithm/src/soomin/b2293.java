package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


/* 2293번 동전1
 * 동전이 주어지고, 그 가치는 전부 다르다.
 * 이 동전을 적당히 사용해서 k원을 나타내고 싶다.
 * k원을 나타낼 수 있는 가짓수를 구하라.
 * 각 동전은 무한하게 있다.
 * */

/*  문제 풀이 방법
 *  점화식 DP[N][k] = DP[N-1][k] + N번째 해당하는 수 + DP[N][K- N에 해당하는 수]
 * */

public class b2293 {

    // N = 동전의 가짓수, K = 나타내고 싶은 값
    static int N, K;
    static int [] coinV;
    static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coinV = new int[N+1];
        dp = new int [K+1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            coinV[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <= K; j++) {
                if(j < coinV[i]) {
                    dp[j] = dp[j];
                }
                else {
                    dp[j] += dp[j - coinV[i]];
                }
            }
        }


        System.out.println(dp[K]);

    }

}
