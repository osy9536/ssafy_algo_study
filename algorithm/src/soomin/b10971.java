package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10971 {
    static int N;
    static int originStart;
    static int [][] arr;
    static boolean [] flag;
    static int sum = 0;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //1. 입력 받기
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];



        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            flag = new boolean[N];
            flag[i] = true;
            originStart = i;
            dfs(i,1);
        }

        System.out.println(min);


    }

    public static void dfs(int start, int deepth) {

        // 만약 더 이상 갈 곳이 없으면 돌아온다.
        if(deepth == N) {

            if(arr[start][originStart] ==0) {
                return;
            }else {
                sum += arr[start][originStart];
                min = Math.min(min, sum);
                sum -= arr[start][originStart];
                return;
            }
        }




        for (int i = 0; i < arr[start].length; i++) {

            // 방문하지 않았고, 길이 있다면,
            if(arr[start][i] !=0 && !flag[i]) {
                flag[i] = true;
                sum += arr[start][i];
                dfs(i, deepth+1);
                // 한번 가보고 안되면 미 방문으로 돌리고, 합계에서도 빼기
                flag[i] = false;
                sum -= arr[start][i];
            }
        }

        // 만약 현재 정점에서 더 이상 갈 곳이 없는 경우 돌아온다.
        return;


    }
}
