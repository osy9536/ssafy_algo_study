package algorithm.src.soomin;

import java.util.*;
import java.io.*;

public class b2206{

    static int N,M;
    static int [][] arr;

    static int [][][] isVisited;

    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        // 입력 받기 -------------------------------------------------------
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        isVisited = new int[N+1][M+1][2];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j+1] = Character.getNumericValue(s.charAt(j));
            }
        }

        if(N == 1 && M==1){
            System.out.println(1);
            return;
        }

        // 벽 부수거나, 안 부수고 그냥 사방탐색하거나
        // -> 1번 계층: 벽 부술 권리가 아직 존재하는 계층
        // -> 0번 계층: 벽 부수고 이동하는 계층
        ArrayDeque<Move2> aq1 = new ArrayDeque<>();
        aq1.add(new Move2(1,1,1));

        int cnt = 1;
        while(!aq1.isEmpty()){
            cnt++;
            int Qsize = aq1.size();
            for (int i = 0; i < Qsize; i++) {
                Move2 cur = aq1.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + idx[j];
                    int ny = cur.y + idy[j];
                    int crash = cur.crash;

                    if(nx >=1 && ny >=1 && nx <= N && ny <= M){
                        if(crash == 1){
                            if(arr[nx][ny] == 0 && isVisited[nx][ny][1] == 0){
                                isVisited[nx][ny][1] = cnt;
                                aq1.add(new Move2(nx,ny,1));
                            }

                            if(arr[nx][ny] == 1 && isVisited[nx][ny][0] == 0){
                                isVisited[nx][ny][0] = cnt;
                                aq1.add(new Move2(nx,ny,0));
                            }
                        }

                        if(crash == 0){
                            if(arr[nx][ny] == 0 && isVisited[nx][ny][0] == 0){
                                isVisited[nx][ny][0] = cnt;
                                aq1.add(new Move2(nx,ny,0));
                            }
                        }
                    }
                }
            }
        }

        // 도달하지 못하는 경우 --------------------------------------------------
        if(isVisited[N][M][0] == 0 && isVisited[N][M][1] == 0){
            System.out.println(-1);
            return;
        }


        System.out.println(Math.min(isVisited[N][M][0] == 0? Integer.MAX_VALUE : isVisited[N][M][0],
                isVisited[N][M][1] == 0? Integer.MAX_VALUE : isVisited[N][M][1]));

    }

}

class Move2 {
    int x;
    int y;
    int crash;

    public Move2(int x, int y, int crash ) {
        this.x = x;
        this.y = y;
        this.crash = crash;
    }
}

