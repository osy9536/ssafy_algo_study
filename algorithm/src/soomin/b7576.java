package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class b7576 {

    static int N,M;
    static int [][] arr;

    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];


        ArrayDeque<Zhapho5> aq1 = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value =Integer.parseInt(st.nextToken());
                arr[i][j] = value;

                if(value == 1){
                    aq1.add(new Zhapho5(i,j));
                }
            }
        }

        int days = 0;
        while (!aq1.isEmpty()){
            int Qsize = aq1.size();
            int isValid = 0;
            for (int i = 0; i < Qsize; i++) {
                Zhapho5 cur = aq1.poll();

                for (int j = 0; j < 4; j++) {

                    int nx = cur.x + idx[j];
                    int ny = cur.y + idy[j];

                    if(nx >=0 && ny >=0 && nx < N && ny < M && arr[nx][ny] != -1 && arr[nx][ny] != 1){
                        arr[nx][ny] = 1;
                        aq1.add(new Zhapho5(nx,ny));
                        isValid++;
                    }
                }
            }
            if(isValid>0){
                days++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }
}

class Zhapho5 {
    int x;
    int y;

    public Zhapho5(int x, int y){
        this.x = x;
        this.y = y;
    }
}
