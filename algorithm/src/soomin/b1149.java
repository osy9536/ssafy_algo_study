package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1149 {

    static int N,sum;
    static int min = Integer.MAX_VALUE;

    // 각 집마다 무슨 색으로 칠할지 결정하여 저장 -> index가 집의 위치, 원소 값이 집이 칠할 색깔을 뜻함
    static int [][] houses = new int[1001][4];;

    // dp[N]은 N일 떄의 최소값
    // dp[N] = dp[N-1] + min(N);

    static int [][] dp = new int[1001][4];

    // red - 1, green - 2, blue - 3
    static int [] color = new int [] {1,2,3};





    // dfs로 푸는데, 배열에 다 저장해야겠다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 행 집, 열- 색깔별 비용






        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
            houses[i][3] = Integer.parseInt(st.nextToken());
        }


        setColor(1);
        System.out.println(min);

    }


    public static void setColor(int deepth) {

        if(deepth > N) {
            min = Math.min(dp[N][1], dp[N][2]);
            min = Math.min(dp[N][3], min);
            return;
        }


        if(deepth == 1) {
            dp[1][1] = houses[1][1];
            dp[1][2] = houses[1][2];
            dp[1][3] = houses[1][3];
            setColor(deepth+1);
        }

        dp[deepth][1] =houses[deepth][1] + Math.min(dp[deepth-1][2], dp[deepth-1][3]);
        dp[deepth][2] =houses[deepth][2] + Math.min(dp[deepth-1][1], dp[deepth-1][3]);
        dp[deepth][3] =houses[deepth][3] + Math.min(dp[deepth-1][1], dp[deepth-1][2]);
        setColor(deepth+1);


    }
}
