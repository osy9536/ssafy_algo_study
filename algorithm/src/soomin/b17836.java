package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*공주님 구하기 bfs 문제
 * 명검 그람을 획득하지 않은 채로 공주한테 가는 bfs 구하기
 * 명검 그람까지 가고 그 자리에서 부터 공주 자리까지 가는 거리 구하기
 * 둘 다 T시간 이내로 못 오면 fail 띄우기
 * */

public class b17836 {

    static int N,M,T, cnt;
    static int [][] arr;
    static boolean[][] flag;

    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    static int [] swordsX = {0,1};
    static int [] swordsY = {1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr= new int [N+1][M+1];
        flag= new boolean[N+1][M+1];


        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = bfs();

        System.out.println(ans<=T? ans : "Fail");

    }

    public static int bfs() {

        int ansWithSwords = Integer.MAX_VALUE;
        int ansWithJustGo = Integer.MAX_VALUE;

        ArrayDeque<Coordinate33> aq1 = new ArrayDeque<>();
        aq1.add(new Coordinate33(1, 1));
        flag[1][1] = true;

        cnt = 1;
        loopout:
        while(!aq1.isEmpty()) {
            int qSize = aq1.size();


            for (int i = 0; i < qSize; i++) {
                Coordinate33 cur = aq1.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + idx[j];
                    int ny = cur.y + idy[j];

                    if(nx>= 1 && ny >=1 && nx<=N && ny<=M && (arr[nx][ny] !=1) && !flag[nx][ny]) {

                        if(nx == N && ny == M && arr[N][M] == 0){

                            ansWithJustGo = cnt;
                            break loopout;
                        }
                        if(arr[nx][ny] == 2){
                            ansWithSwords = cnt+(N-nx)+(M-ny);

                        }

                        arr[nx][ny] = 8;
                        flag[nx][ny] = true;
                        aq1.add(new Coordinate33(nx, ny));
                    }
                }
            }
            cnt++;
        }



        return Math.min(ansWithJustGo,ansWithSwords);
    }
}

class Coordinate33 {
    int x;
    int y;


    public Coordinate33(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
