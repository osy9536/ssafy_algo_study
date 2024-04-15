import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 감소하는 수 - 조합
 * (1) 조합으로 구해야하는 값의 자릿수 선정
 * (2) 해당 자릿수에서 시작 숫자 선정
 * (3) 시작 숫자에서 역순으로 값 구하기
 * */

public class Main {

    static int N;
    static char [][] arr;

    static int [] idx = {1,0,-1,0};
    static int [] idy = {0,1,0,-1};

    static int maxStreak = 0;

    public static void main(String[] args) throws IOException {

        // 1. 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }



        /*
         * 2) 계산
         * 2-1) 인접한 녀석이 다르면 서로 위치 교환
         * 2-2) 행 검사 -> Streak Max 값 잡고, 한 행 검사
         * 2-3) 열 검사 -> Streak Max 값 잡고, 한 열 검사
         * */

        exchange();

        System.out.println(maxStreak);
    }

    public static void exchange() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                char now = arr[i][j];

                for (int k = 0; k < 4; k++) {
                    int nx = i + idx[k];
                    int ny = j + idy[k];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    if(now != arr[nx][ny]){

                        // 위치 바꾸기 -> C++ 생각남...
                        char temp = arr[nx][ny];
                        arr[nx][ny] = arr[i][j];
                        arr[i][j] = temp;

                        checkRow();
                        checkCol();

                        // 원위치 돌리기
                        temp = arr[nx][ny];
                        arr[nx][ny] = arr[i][j];
                        arr[i][j] = temp;

                    }
                }
            }
        }
    }


    public static void checkRow() {

        for (int i = 0; i < N; i++) {
            char prev = '0';
            int small_streak = 0;
            for (int j = 0; j < N; j++) {
                if(j == 0){
                    prev = arr[i][j];
                    small_streak++;
                }else {
                    if(arr[i][j] == prev){
                        small_streak++;
                        prev = arr[i][j];
                    }else {
                        small_streak = 1;
                        prev = arr[i][j];
                    }
                    maxStreak = Math.max(small_streak, maxStreak);
                }
            }
        }
    }

    public static void checkCol() {

        for (int i = 0; i < N; i++) {

            char prev = '0';
            int small_streak = 0;

            for (int j = 0; j < N; j++) {
                if( j == 0){
                    prev = arr[j][i];
                    small_streak++;
                }else {

                    if(arr[j][i] == prev){
                        small_streak++;
                        prev = arr[j][i];
                    }else {
                        small_streak = 1;
                        prev = arr[j][i];
                    }

                    maxStreak = Math.max(small_streak, maxStreak);
                }

            }


        }

    }
}
