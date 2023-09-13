package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N+1][N+1];

        int [][] ans = new int[N+1][N+1];
        boolean[][]flag;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();

        // 바로 갈 수 있는 것 체크
        for (int i = 1; i <= N; i++) {

            flag  = new boolean[N+1][N+1];

            for (int j = 1; j <= N; j++) {
                if(arr[i][j] == 1){
                    aq1.add(j);
                    ans[i][j] = 1;
                    flag[i][j] = true;
                }
            }

            while(!aq1.isEmpty()){

                int cur = aq1.poll();
                for (int j = 1; j <= N; j++) {
                    if(arr[cur][j] == 1 && !flag[cur][j]){
                        aq1.add(j);
                        flag[cur][j]= true;
                        // cur이란 정점을 타고 j에 닿을 수 있다는 것은 결국 i -> j로의 경로가 있다는 말이다.
                        ans[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }


    }
}
