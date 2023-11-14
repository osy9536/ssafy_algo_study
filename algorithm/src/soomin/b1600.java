package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b1600 {

    static int K, W, H;

    // 2 == where monkey visited , 1 === wall
    static int [][] arr;

    //x-> height, y-> width, z-> remaining cnt of being horse
    static int [][][] isVisited;

    // Horse mode move idx, idy
    static int [] hx = {-2,-2, -1, 1, 2, 2, -1, 1};
    static int [] hy = {-1, 1,  2, 2,-1, 1,-2,-2};

    // Monkey mode move idx, idy
    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        //input data --------------------------------------------------------------
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // W는 가로 길이, H는 세로길이임
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        arr = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(W == 1 && H == 1 && arr[H-1][W-1] == 0){
            System.out.println(0);
            return;
        }

        if(W == 1 && H == 1 && arr[H-1][W-1] == 1){
            System.out.println(-1);
            return;
        }

        isVisited = new int[H][W][K+1];

        ArrayDeque<Move> aq1 = new ArrayDeque<>();
        aq1.add(new Move(0,0, K));

        int cnt = 0;
        while (!aq1.isEmpty()){
            cnt++;
            int Qsize = aq1.size();
            for (int i = 0; i < Qsize; i++) {
                Move cur = aq1.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + idx[j];
                    int ny = cur.y + idy[j];

                    // 인접 좌표로만 이동 했을 때, 이동하려는 곳이 벽이 아니어야하고, 이전에 방문하지 않았어야 한다.
                    if(nx >=0 && ny >=0 && nx <H && ny < W && arr[nx][ny] ==0 && isVisited[nx][ny][cur.BeingHorse] == 0){
                        isVisited[nx][ny][cur.BeingHorse] = cnt;
                        aq1.add(new Move(nx,ny, cur.BeingHorse));
                    }

                }

                if(cur.BeingHorse >0){
                    for (int j = 0; j < 8; j++) {
                        int nx = cur.x + hx[j];
                        int ny = cur.y + hy[j];

                        // 말로 이동했을 때, 배열안에 값이 들어오고, 말이 되어 도달할 좌표가 벽이 아니어야 하고
                        // 말이 되서 움직이는 경우가 K번 남은 계층에서 그 좌표로의 방문이 없어야함.
                        // 나중에 오는 경우가 더 최단 거리일 수 있지 않나? NO!
                        // 만약 이미 방문 하였다면, 전에 그 장소를 먼저 말이 되는 경우를 사용해서라도 방문 했을 것임.
                        // 따라서 후에 진입한 값은 전에 진입한 값보다 크기가 크거나 같다.
                        if(nx >=0 && ny >=0 && nx <H && ny <W && arr[nx][ny] ==0  &&isVisited[nx][ny][cur.BeingHorse-1] == 0){
                            isVisited[nx][ny][cur.BeingHorse-1] = cnt;
                            aq1.add(new Move(nx,ny, cur.BeingHorse-1));
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= K; i++) {
            min = Math.min(min, isVisited[H-1][W-1][i] == 0? Integer.MAX_VALUE : isVisited[H-1][W-1][i]);
        }

        System.out.println(min == Integer.MAX_VALUE? -1 : min);

    }

}

class Move {
    int x;
    int y;

    int BeingHorse;

    public Move(int x, int y, int BeingHorse) {
        this.x = x;
        this.y = y;
        this.BeingHorse = BeingHorse;
    }
}
