package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b11404 {

    // 플로이드 - 워샬
    // 처음에는 직접 경로로 dp를 채운다.
    // 두번째는 첫번째 경유지를 고려한 값과 그 직전 값 중 작은 값을 저장
    // 세번째는 첫번째 경유지와 직접 거리 중 최소값과 첫번째 경유지,두번째 경유지 모두 고려 했을 때 값 중 최소 값 저장
    // 배열 자체를 계속 최신화 해주기 때문에 dp0는 모두 직접 거리, dp1은 경유지 1을 고려했을 때의 최소거리... 이런 식으로 간다.
    // dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
    static int N;
    static int Bus;
    static long [][] Cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Bus = Integer.parseInt(br.readLine());

        Cities = new long[N+1][N+1];

        // 최초 직접 거리 저장
        for (int i = 0; i < Bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(Cities[start][end] == 0){
                Cities[start][end] = weight;
            }else{
                if(Cities[start][end] > weight){
                    Cities[start][end] = weight;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(Cities[i][j] == 0 && i != j){
                    Cities[i][j] = Integer.MAX_VALUE;
                }
            }
        }

//        System.out.println("플로이드- 워샬 돌리기 전");
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(Cities[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("--------------------");


        // 플로이드 - 워샬

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if(i != k){
                    for (int j = 1; j <= N; j++) {
                        if(j != i && j !=k){ // 경유지와 출발지, 경유지와 도착지, 출발지와 도착지 모두 같지 않은 경우만 유효함.
                            Cities[i][j] = Math.min(Cities[i][j], Cities[i][k] + Cities[k][j]);
                        }
                    }
                }
            }
        }

        long ans;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans = Cities[i][j] >= Integer.MAX_VALUE? 0 : Cities[i][j];
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}