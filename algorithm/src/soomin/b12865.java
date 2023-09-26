package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12865 {

    // 0-1 knapSack k[i][w] 물건을 1~i번째 까지 고려할 때, 무게를 w를 까지 넣을 수있는 가방에서 나올 수 있는 최대 가치
    // k[i][w]는 i란 물건을 가방에 넣거나, 아님 빼거나 두 경우 중 최대값임.
    // 따라서 k[i][w] = Math.max(V + k[i-1][w-W], k[i-1][w])
    // => 해당 아이템 넣고, 아이템이 들어간 공간 이외의 공간에서 최대 가치 창출 혹은 해당 아이템을 안 넣고 최대 가치 창출
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int itemCount = Integer.parseInt(st.nextToken());
        int weightAmount = Integer.parseInt(st.nextToken());

        // dp[i][k]는 위에 나온 설명 그대로, 행이 한 줄 더 있는 것은 dp가 직전 값을 참조해야하는 점 때문에 채웠다.
        // 열이 하나 더 있는 것은 열의 index가 현재 최대 무게와 일치하도록 하기 위해서이다.
        // 또한 dp 계산에서는 i번째 아이템을 가방에 담은 경우, 가방의 여분공간에서 뽑을 수 있는 최대 가치를 더해줘야 하는데,
        // i의 무게와 가방의 최대용량이 같은 경우, 여분의 공간이 없으므로 0을 더해줘야 한다.
        // 이 역할도 dp[i][0]열이 대신해준다. 해당 열은 전부 디폴트 초기화만 해줄 것이니 값이 전부 0이 된다.
        int [][] dp = new int[itemCount+1][weightAmount+1];

        Item [] items = new Item[itemCount+1];

        items[0] = new Item(0,0);

        for (int i = 1; i <= itemCount; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i] = new Item(v, w);
        }

        for (int i = 1; i <= itemCount ; i++) {
            for (int j = 1; j <= weightAmount; j++) {
                // 현재 아이템의 무게가 넣을 수 있는 가방의 최대 용량을 넘는 경우,
                if(items[i].W > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(items[i].V + dp[i-1][j-(items[i].W)], dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[itemCount][weightAmount]);

    }
}

class Item {
    int V;
    int W;

    public Item(int V, int W) {
        this.V = V;
        this.W = W;
    }
}