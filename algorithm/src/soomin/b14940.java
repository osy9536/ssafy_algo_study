package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b14940 {

    static int N,M, goalX, goalY;

    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    static int [][] arr;
    static boolean [][] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        flag = new boolean[N][M];

        // 값 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = (temp  == 1? -1 : temp);

                if(arr[i][j] == 2){
                    goalX = i;
                    goalY = j;
                }
            }
        }

        bfs(goalX, goalY);

        for (int[] temp :
                arr) {
            for (int a :
                    temp) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int goalX, int goalY) {
        ArrayDeque<dfd> q1 = new ArrayDeque<>();
        q1.add(new dfd(goalX, goalY));

        arr[goalX][goalY] = 0;

        flag[goalX][goalY] = true;

        int nowDistance = 1;
        while(!q1.isEmpty()){

            int Qsize = q1.size();

            for (int i = 0; i < Qsize; i++) {
                dfd cur = q1.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + idx[j];
                    int ny = cur.y + idy[j];

                    if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny] != 0){

                        if(flag[nx][ny]) continue;

                        arr[nx][ny] = nowDistance;
                        flag[nx][ny] = true;
                        q1.add(new dfd(nx,ny));
                    }
                }
            }
            nowDistance++;
        }


    }

}

class dfd {
    int x;
    int y;

    dfd(int x, int y){
        this.x = x;
        this.y = y;
    }
}
