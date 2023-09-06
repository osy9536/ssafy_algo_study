package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*tomato bfs 문제*/

public class b7569 {

    //가로, 세로, 높이
    static int M,N,H;

    static int [][][] boxDummy;
    static boolean [][][] isVisited;
    static int isAlreadyRipen = 0;

    // 북동남서 위 아래
    static int [] idx = {-1,0,1,0,0,0};
    static int [] idy = {0,1,0,-1,0,0};
    static int [] idz = {0,0,0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        boxDummy = new int [H][N][M];
        isVisited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxDummy[i][j][k] = Integer.parseInt(st.nextToken());
                    if(boxDummy[i][j][k]== 1) {
                        isAlreadyRipen++;
                        isVisited[i][j][k] = true;
                    }else if(boxDummy[i][j][k]== -1) {
                        isAlreadyRipen++;
                    }
                }
            }
        }

        if(isAlreadyRipen == (N*M*H)) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        ArrayDeque<coordinate> aq1 = new ArrayDeque<>();

        // flag 배열을 돌면서 true인 녀석들을 모두 대기열에 넣는다.
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(isVisited[i][j][k]) {
                        aq1.add(new coordinate(i, j, k));
                    }
                }
            }
        }
        // bfs 돌린다.
        int day = 0;
        while(!aq1.isEmpty()) {
            int Qsize = aq1.size();
            for (int i = 0; i < Qsize; i++) {
                coordinate cur = aq1.poll();

                for (int j = 0; j < 6; j++) {
                    int nH = cur.height + idz[j];
                    int nV = cur.vertical + idx[j];
                    int nGaro = cur.horizontal+ idy[j];

                    if(nH>=0 && nV>=0 && nGaro>=0  && nH<H && nV<N && nGaro<M
                            && !isVisited[nH][nV][nGaro] && boxDummy[nH][nV][nGaro] == 0) {
                        boxDummy[nH][nV][nGaro] = 1;
                        isVisited[nH][nV][nGaro] = true;
                        aq1.add(new coordinate(nH, nV, nGaro));
                    }
                }
            }
            day++;
            if(isValid() == 0) {
                return day;
            }
        }

        return -1;
    }

    public static int isValid() {
        for (int[][] temp : boxDummy) {
            for (int[] temp2 : temp) {
                if(Arrays.stream(temp2).anyMatch(x-> x == 0)) {
                    return -1;
                }
            }
        }
        return 0;
    }
}

class coordinate {
    int height;
    int vertical;
    int horizontal;

    coordinate(int height, int vertical, int horizontal){
        this.height = height;
        this.vertical = vertical;
        this.horizontal = horizontal;
    }
}