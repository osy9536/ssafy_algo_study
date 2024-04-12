import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 감소하는 수 - 조합
 * (1) 조합으로 구해야하는 값의 자릿수 선정
 * (2) 해당 자릿수에서 시작 숫자 선정
 * (3) 시작 숫자에서 역순으로 값 구하기
 * */

public class Main {


    // 1) 배열의 크기
    static int N, M;

    // 2) 청소기의 현 위치와 방향
    static int X, Y, d;

    static int [][] arr;

    static int cleaningCnt = 0;

    // 2) 반시계 방향으로 세팅 (북: 0 , 동: 1, 남: 2, 서: 3)
    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        operatingRobotVacuumCleaner();
        System.out.println(cleaningCnt);
    }


    // 1) 방 청소
    public static void Cleaning (int x, int y){
        arr[x][y] = 2;
        cleaningCnt++;
    }

    // 2) 바라보는 방향 바꾸기 바꾸기
    public static void ChangingDirection(int currentDNum) {
        switch (currentDNum) {
            case 0:
                d = 3;
                break;
            case 1:
                d = 0;
                break;
            case 2:
                d = 1;
                break;
            case 3:
                d = 2;
                break;
        }
    }

    // 3) 전진
    public static boolean Forward(int x, int y) {

        int nx = x + idx[d];
        int ny = y + idy[d];

        if(arr[nx][ny] == 0){

            // 비어있다면 전진 후
            X = nx;
            Y = ny;

            // 청소
            Cleaning(nx,ny);

            return  true;
        }

        return false;
    }

    // 4) 후진
    public static boolean Back (int x, int y){

        // 후진 하는 방향 설정
        int nx = 0;
        int ny = 0;
        // (북: 0 , 동: 1, 남: 2, 서: 3)
        switch (d) {
            case 0:
                nx = x + idx[2];
                ny = y + idy[2];
                break;
            case 1:
                nx = x + idx[3];
                ny = y + idy[3];
                break;
            case 2:
                nx = x + idx[0];
                ny = y + idy[0];
                break;
            case 3:
                nx = x+ idx[1];
                ny = y+ idy[1];
                break;
        }

        // 벽이 아니면 후진
        if(arr[nx][ny] != 1){
            X = nx;
            Y = ny;
            return true;
        }else {

            // 벽이면 거기서 작동을 멈추기에 끝난다.
            return false;
        }
    }

    public static void operatingRobotVacuumCleaner() {

        // -1) 일단 지 자리를 닦는다.
        Cleaning(X,Y);

        // 0) 현재 청소기가 계속 작동 중인가?

        boolean isStillRunning = true;


        while (isStillRunning) {
            // 1) 사방 4칸이 청소된 칸인지 아닌지 확인
            boolean isClean = true;

            for (int i = 0; i < 4; i++) {
                int nx = X + idx[i];
                int ny = Y + idy[i];

                if(arr[nx][ny] == 0){
                    isClean = false;
                    break;
                }
            }

            // 2) 4칸 중 청소되지 않은 빈칸이 있는 경우
            if(!isClean) {

                boolean isGoing = false;

                // 전진할 때 까지 반복
                while (!isGoing){
                    ChangingDirection(d);
                    isGoing = Forward(X,Y);
                }

                // 3) 4칸 중 청소되지 않은 칸이 없는 경우
            }else {
                isStillRunning = Back(X,Y);
            }
        }
    }
}
