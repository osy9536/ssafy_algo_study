package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16918 {

    static int R,C,N;
    static int[][] arr;
    static boolean[][] flag;
    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j) == '.' ? 0 : 2;
            }
        }

        dfs(0);

        for (int[] temp :
                arr) {
            for (int a :
                    temp) {
                if (a == 0) {
                    sb.append('.');
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 1초부터 시작
    public static void dfs(int deepth){

        if(deepth == 0){
            dfs(deepth+1);
            return;
        }

        if(deepth == N){
            return;
        }


//        if(deepth == 2){
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    arr[i][j] = (arr[i][j] == 0? 3 : arr[i][j]);
//                }
//            }
//        }
        else{
            flag = new boolean [R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {



                    if(arr[i][j] == deepth && !flag[i][j]){
                        arr[i][j] = 0;
                        flag[i][j]= true;

                        for (int k = 0; k < 4; k++) {
                            int nx = i + idx[k];
                            int ny = j + idy[k];

                            if(nx>=0 && ny >=0 && nx<R && ny <C){
                                if(arr[nx][ny] ==deepth) continue;
                                flag[nx][ny] = true;
                                arr[nx][ny] = 0;
                            }
                        }

                    }else if(arr[i][j] == 0 && !flag[i][j]){
                        arr[i][j] = deepth+3;
                    }
                }
            }
        }

        dfs(deepth+1);


    }
}
