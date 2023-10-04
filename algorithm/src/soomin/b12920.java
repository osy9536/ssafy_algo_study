package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 *   평범한 배낭2
 *   0-1 knapsack 문제인데, 물건의 갯수가 추가되었다.
 */

// 문제가 다 똑같다.

/*  문제 풀이
    1. 일단 dp로 0-1knapsack 풀듯이 푼다. => 기본 골격은 같음
    2. 근데 이제 최대용량보다 현재 넣는 값이 무게가 작을 때, 여분 공간에 대하여, 만약 동일 아이템의 갯수가 남았을 시,
       동일 아이템을 넣었을 때의 최대 가치, 저번 아이템을 넣었을 때 최대 가치, 그냥 아이템 넣지 않았을 때의 최대가치 중 최대값을 넣어야함.
    3. 그래서 동일 행, 저번 행 전부 확인
*/

public class b12920 {


    // N은 물건의 수, M은 최대 무게
    static int N,M;
    static int [][] dp;

    static ArrayList<Item2> items = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        items.add(new Item2(0,0,0));
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            if(cnt == 1){
                items.add(new Item2(v,w,cnt));
            }else{
                // 물건이 N개 라면, 2의 제곱 수로 나누어서 각각 하나의 물건으로 만든다.
                // 물건을 가능한 2의 제곱 수로 나누면, 1~N 전부를 생각하고, 하나씩 가방에 넣어보는 계산 없이 풀 수 있다.
                // 예를 들어 물건의 개수가 15개이면,
                // 1,2,4,8 로 물건을 나누고, 각각의 하나의 다른 물건으로 취급하면,
                // 1~15까지의 물건을 포함한 경우, 미포함한 경우를 전부 고려하여 최적해를 나타내는게 가능하다.
                // (행을 거칠 때마다 1~15를 하나씩 고려하면서 최적해 계산이됨.)

                // 주의해야할 점은 물건의 개수가 13인 경우처럼, 2의 제곱으로 정확히 값이 안 떨어지는 경우이다.
                // 13일 때도, 2의 제곱은 1,2,4,8로 나오는데, 고려되는 수는 13이 아니라 1~15까지가 된다.
                // 이때는 제하고 남은 cnt의 수와 현재 구할 2의 제곱 수 중 낮은 수로 값을 구하면 된다.
                // 그러면 13일 경우 1,2,4,6이되고, 이는 1~13까지만 고려가 가능하다.

                for (int j = 0; cnt > 0; j++) {
                    // 2의 제곱승과 계속 비교
                    int min  = Math.min(cnt, 1 << j);

                    // 갈라진 물건의 수만큼 새로운 물건으로 취급하고, 가치와 무게도 새로 계산한다.
                    int nV = v*min;
                    int nW = w*min;

                    items.add(new Item2(nV,nW, min));
                    cnt -= min;
                }
            }

        }


        // 0행과 0열은 각각 아무것도 안 담겼을 때(행), 이미 배낭이 꽉 찼을 때(열)를 나타내기 위해 비워둬야함
        // dp[i][j]는 i번째 아이템까지 가방 용량이 최대 j일 때의 가장 큰 가치
        dp = new int[items.size()][M+1];


        // i -> item index, j -> backpack weight
        for (int i = 1; i < items.size(); i++) {
            for (int j = 1; j <= M; j++) {

                // 현재 아이템의 무게가, 동적으로 최대용량이 바뀌는 가방의 현재 무게보다 클 때,
                if(items.get(i).W > j){
                    dp[i][j] = dp[i-1][j];
                }
                //현재 아이템의 무게가, 가방의 현재 무게보다 작을 때,
                //
                else{
                    dp[i][j] = Math.max(dp[i-1][j], items.get(i).V + dp[i-1][j-items.get(i).W]);
                }
            }
        }

        System.out.println(dp[items.size()-1][M]);



    }
}

// item class 여기에 가치, 무게, 갯수를 카운트 한다.
class Item2{
    int V;
    int W;
    int cnt;

    public Item2(int value, int weight, int cnt){
        this.V = value;
        this.W = weight;
        this.cnt = cnt;
    }
}