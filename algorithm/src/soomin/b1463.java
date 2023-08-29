package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class b1463 {

    static int N;
    static int cnt = 0;

    static int [] arr = new int [1000001];
    static boolean [] flag = new boolean [1000001];
    static int [] dp = new int [1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

//		bfs();
//		System.out.println(cnt-1);

        dp();
        System.out.println(dp[N]);

    }

    // bfs로 푼 경우
    public static void bfs() {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        q1.offer(N);
        flag[N] = true;

        out:
        while(!q1.isEmpty()) {
            int Qsize = q1.size();
            cnt++;
            for (int i = 0; i < Qsize; i++) {
                int current = q1.poll();
                arr[current] = cnt;
                if(current == 1) break out;


                if(!flag[current/2] && current/2 >=0 && current%2 == 0) {
                    flag[current/2] = true;
                    q1.add(current/2);
                }
                if(!flag[current/3] && current/3 >=0 && current%3 == 0) {
                    flag[current/3] = true;
                    q1.add(current/3);
                }
                if(!flag[current-1] && current-1>=0) {
                    flag[current-1] = true;
                    q1.add(current-1);
                }

            }
        }

    }

    // dp로 푼 경우
    public static void dp() {
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <=N; i++) {
            dp[i] = dp[i-1]+1;

            if(i%2==0) {
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }
            if(i%3 == 0) {
                dp[i] = Math.min(dp[i/3]+1 , dp[i]);
            }
        }

    }

}
