package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class b3055 {

    //-----------------------INFO------------------------------
    // 고슴도치 위치(시작점): S , 비버의 굴(도착지): D, 비어있는 곳: .
    // 물이 차 있는 곳(상하좌우 확장): *, 돌(물,고슴도치 못 감): x
    //---------------------------------------------------------


    static int R,C;
    static int cnt = 0;

    // DF은 방문 체크
    // 빈공간: 0 , 벽: 1, 물: 2, 고슴도치: 3, 비버굴: 4
    static int [][] DF;

    static int hedgeX, hedgeY;

    static int BiberX, biberY;
    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};




    // bfs로 S에서 움직인다. 물(*)도 BFS로 움직인다. *이 S보다 먼저 Bfs로 움직임, 떠난 자리는 다시 .으로 채워넣는다. -> *이 채울 수 있게
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        DF = new int [R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {

                switch (s.charAt(j)) {
                    case '.': {
                        DF[i][j] = 0;
                        break;
                    }
                    case 'X': {
                        DF[i][j] = 1;
                        break;
                    }
                    case '*': {
                        DF[i][j] = 2;
                        break;
                    }
                    case 'S':{
                        DF[i][j] = 3;
                        hedgeX = i;
                        hedgeY = j;
                        break;
                    }
                    case 'D':{
                        DF[i][j] = 4;
                        BiberX = i;
                        biberY = j;
                        break;
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < 4; i++) {
            int nx = BiberX+ idx[i];
            int ny = biberY + idy[i];

            if(nx >=0 && ny>=0 && nx<R && ny<C
                    &&DF[nx][ny] == 3){
                System.out.println(cnt);
                return;
            }
        }

        System.out.println("KAKTUS");

    }

    public static  void bfs() {


        ArrayDeque<ZhaPho> water = new ArrayDeque<>();
        ArrayDeque<ZhaPho> hedge = new ArrayDeque<>();

        hedge.add(new ZhaPho(hedgeX,hedgeY));

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(DF[i][j] == 2){
                    water.add(new ZhaPho(i,j));
                }
            }
        }


        loopout:
        while (! hedge.isEmpty()){

            // 물 먼저 bfs
            int Wsize = water.size();
            for (int i = 0; i < Wsize; i++) {
                ZhaPho curW = water.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = curW.x + idx[j];
                    int ny = curW.y + idy[j];

                    if(nx >=0 && ny>=0 && nx<R && ny<C
                            && DF[nx][ny] != 1 && DF[nx][ny] != 2
                            && DF[nx][ny] != 3 && DF[nx][ny] != 4){
                        DF[nx][ny] = 2;
                        water.add(new ZhaPho(nx,ny));
                    }
                }

            }

            int Qsize = hedge.size();
            for (int i = 0; i < Qsize; i++) {

                // 같은 턴에 고슴도치 bfs
                ZhaPho cur = hedge.poll();

//                DF[cur.x][cur.y] = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + idx[j];
                    int ny = cur.y + idy[j];



                    if(nx >=0 && ny>=0 && nx<R && ny<C
                            && DF[nx][ny] != 1 && DF[nx][ny] != 2
                            && DF[nx][ny] != 3 ){
                        if(DF[nx][ny] == 4){
                            cnt +=1;
                            break loopout;
                        }
                        else {
                            DF[nx][ny] = 3;
                            hedge.add(new ZhaPho(nx, ny));
                        }
                    }
                }
            }
            cnt++;
        }


    }
}

class ZhaPho{
    int x;
    int y;

    public ZhaPho(int x, int y){
        this.x = x;
        this.y = y;
    }
}