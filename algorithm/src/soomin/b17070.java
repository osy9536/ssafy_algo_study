package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17070 {

    static int N;
    static int [][] arr;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int [N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[0][1] = 2;
        arr[0][0] = 2;

        go(0,1);
        System.out.println(cnt);
    }

    // 파이프 끝단
    public static void go(int x, int y) {

        if(x == N-1 && y == N-1) {
            cnt++;
            return;
        }

        // 벽이거나, 집을 벗어나면 유효한 움직임이 아니므로, 다른 선택지를 가거나, 뒤로 돌아가야함.

        // 1. 파이프가 가로로 누워있으면 가로, 대각선만 갈 수 있음
        if(y-1 >=0
                && arr[x][y-1] == 2
                && y+1 < N
                && arr[x][y+1] != 1) {
            arr[x][y-1] = 0;
            arr[x][y+1] = 2;
            go(x,y+1);
            arr[x][y-1] = 2;
            arr[x][y+1] = 0;

            if(x+1 <N && arr[x+1][y+1] != 1 && arr[x+1][y]!=1) {
                arr[x][y-1] = 0;
                arr[x+1][y+1] = 2;
                go(x+1,y+1);
                arr[x][y-1] = 2;
                arr[x+1][y+1] = 0;
            }
        }

        // 2. 파이프가 세로로 누워있으면 세로, 대각선만 갈 수 있음
        if(x-1 >= 0
                && arr[x-1][y] == 2
                && x+1 <N
                && arr[x+1][y] != 1) {
            arr[x-1][y] = 0;
            arr[x+1][y] = 2;
            go(x+1,y);
            arr[x-1][y] = 2;
            arr[x+1][y] = 0;
            if(y+1 <N && arr[x+1][y+1] != 1 && arr[x][y+1] != 1) {
                arr[x-1][y] = 0;
                arr[x+1][y+1] = 2;
                go(x+1,y+1);
                arr[x-1][y] = 2;
                arr[x+1][y+1] = 0;
            }
        }

        // 3. 파이프가 대각선으로 누워있으면 가로,세로,대각선 모두 가능
        if(x-1 >= 0
                && y-1>= 0
                && arr[x-1][y-1] == 2) {
            if(y+1<N && arr[x][y+1] != 1) {
                arr[x-1][y-1] = 0;
                arr[x][y+1] = 2;
                go(x,y+1);
                arr[x-1][y-1] = 2;
                arr[x][y+1] = 0;
            }

            if(x+1 < N
                    && arr[x+1][y] != 1) {
                arr[x-1][y-1] = 0;
                arr[x+1][y] = 2;
                go(x+1,y);
                arr[x-1][y-1] = 2;
                arr[x+1][y] = 0;
            }

            if(x+1 < N
                    && y+1 < N
                    && arr[x+1][y+1] !=1
                    && arr[x][y+1] != 1
                    && arr[x+1][y] != 1
            ) {
                arr[x-1][y-1] = 0;
                arr[x+1][y+1] = 2;
                go(x+1,y+1);
                arr[x-1][y-1] = 2;
                arr[x+1][y+1] = 0;
            }
        }

    }
}
