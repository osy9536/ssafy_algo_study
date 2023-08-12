package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17406 {
    static int N,M,K;
    static int[][] map,rcs;
    static boolean visited[];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        rcs = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                rcs[i][j] = Integer.parseInt(st.nextToken())-1;
            }
            rcs[i][2] = Integer.parseInt(st.nextToken());
        }
        /////////////////////////Input - end////////////////////////////////////
        // K개수 만큼의 순열을 구하는 함수
        // 해당 순서에 따라 배열을 돌려주는 함수
        visited = new boolean[K];
        permutation(0,new int[K]);
        System.out.println(min);

    }

    //순열 만들기
    static void permutation(int cnt, int[] arr) {
        if(cnt == K) {
            Rotation(arr);
            return;
        }
        for(int i=0; i<K; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            permutation(cnt+1, arr);
            visited[i] = false;
        }
    }
    // 순열이 만들어 졌을 때 배열을 돌리는 함수
    static void Rotation(int[] arr){
        int[][] tmp = new int[N][M];
        for (int j = 0; j < map.length; j++) {
            tmp[j] = map[j].clone();
        }
        for (int k = 0; k < K; k++) {
            int r = rcs[arr[k]][0] ;
            int c = rcs[arr[k]][1] ;
            int s = rcs[arr[k]][2];

            //3,4,2 -> (1,2)  (5,6)
            //2,3,2 -> (0,1)  (4,5)

            //3,4,2 -> (0,1) (5,6)

            int x1 = r - s ;
            int y1 = c - s ;
            int x2 = r + s;
            int y2 = c + s;

            int min = s;
            for (int i = 0; i < min; i++) { // N,M중 작은 값 만큼 반복
                int x = i + x1;
                int y = i + y1;
                int temp = tmp[x][y];

                int idx = 0;
                while (idx < 4) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];
                    if (nx >= x1+i && nx <= x2-i && ny >= y1+i && ny <= y2-i) {
                        tmp[x][y] = tmp[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        idx++;
                    }
                }
                tmp[i + x1][i + 1 + y1] = temp;
            }
            //print(tmp);
        }
        //print(tmp);
        getAnswer(tmp);
    }
    static void getAnswer(int[][] tmp) {
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<M; j++) {
                sum += tmp[i][j];
            }
            min = Math.min(min,sum);
        }
    }  static void print(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

