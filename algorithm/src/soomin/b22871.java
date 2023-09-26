package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b22871 {
    static Long [] arr;
    static Long [] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long maxK = 0;
        long minK = 0;
        long mid = 0;
        long max = 0;

        arr = new Long[N+1];
        dp = new Long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        dp[1] = 0L;
        dp[2] = calculK(1,2);

        for (int i = 3; i <= N; i++) {
            dp[i] = dpCalculOf(i);
        }

        System.out.println(dp[N]);
    }


    // 단순 start -> destination으로 가는 힘을 계산
    public static long calculK(int start, int destination) {

        return  ((long)(destination - start)) * (1 + Math.abs((int)(arr[destination] - arr[start])));
    }

    // dp[destination]에 대한 계산 (cur -> destination으로 가는 힘의 최소값은
    // cur -> i 가는 힘 , i -> destination 가는 힘 중 최대값들을 다 구하고 그 중 최소값이다.
    // (경유지 거쳐서 갈 때, 부분부분 가는 힘 중 최대 중에서 최소값이다. )
    public static long dpCalculOf(int destination){

        long K = Long.MAX_VALUE;
        for (int i = 1; i < destination; i++) {
            K = Math.min(K,Math.max(dp[i],calculK(i,destination)));
        }

        return K;
    }
}
