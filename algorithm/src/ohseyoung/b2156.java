package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 포도주 시식
// silver 1
public class b2156 {
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];

        /*
         *  (N이 1로 주어질 수 있으므로 이럴 때를 위해 조건식을 달아둔다.
         *  또한 dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값이다.
         */
        if(N > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(recur(N));
    }

    static int recur(int N) {

        if(dp[N] == null) {
            int max = Math.max(recur(N - 2), recur(N - 3) + arr[N - 1]);
            dp[N] = Math.max(max + arr[N], recur(N - 1));
    }

        return dp[N];
    }
}
