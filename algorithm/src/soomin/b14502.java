package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b14502 {
    static int N, M;

    static boolean [] notBlock;
    static int [][] lab;
    static int amount =0;

    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int [N][M];
        amount = N*M;
        notBlock = new boolean[N*M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                lab[i][j] = value;

                if(value !=0){
                    notBlock[M*i + j] = true;
                }
            }
        }
        Combination(0,0);
        System.out.println(max);
    }

    public static void Combination(int deepth, int trueCount) {

        if(trueCount == 3){
            bfs();
            return;
        }


        for (int i = deepth; i < amount; i++) {
            if(!notBlock[i]){
                notBlock[i] = true;
                lab[i/M][i%M] = 1;
                Combination(i+1, trueCount+1);
                notBlock[i] = false;
                lab[i/M][i%M] = 0;
            }
        }
    }

    public static void bfs(){
        ArrayDeque<Coord> aq1 = new ArrayDeque<>();
        boolean [] newBlock = Arrays.copyOf(notBlock,notBlock.length);
        int [][] NewLab = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                NewLab[i][j] = lab[i][j];
            }
        }



        // 값 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(NewLab[i][j] == 2){
                    aq1.add(new Coord(i,j));
                }
            }
        }

        //bfs 돌리기


        while(!aq1.isEmpty()){
            int Qszie = aq1.size();
            for (int i = 0; i < Qszie; i++) {
                Coord coor = aq1.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = coor.x + idx[j];
                    int ny = coor.y + idy[j];

                    // 2차원 배열 내에 속하고, 벽이나 바이러스가 아니며, 방문한 곳이 아니라면 바이러스를 퍼트림
                    if(nx >=0 && ny>=0 && nx<N && ny < M
                            && NewLab[nx][ny] == 0 && !newBlock[nx*M + ny]){
                        NewLab[nx][ny] = 2;
                        newBlock[nx*M +ny] = true;
                        aq1.add(new Coord(nx,ny));

                    }
                }
            }
        }
        int cnt=0;
        for (int i = 0; i < newBlock.length; i++) {
            if(!newBlock[i]) cnt++;
        }

        max = Math.max(max, cnt);
    }
}

class Coord{
    int x;
    int y;

    Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}
