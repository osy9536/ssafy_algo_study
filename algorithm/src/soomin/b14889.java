import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

// 14889번 스타트와 링크
public class Main {

    // 사용할 기술: 조합
    // 푸는 방법
    // (A) 반으로 팀 나누기 -> 방문 배열로 갈라진 A팀, B팀 멤버 명시
    // (B) A팀 총 시너지, B팀 총 시너지 계산 -> 각 팀별로 조합
    // (C) 능력치 차이가 최소인지 확인, 현재까지 최소면 능력치 차이 변수 갱신



    // * 입력 받기 위한 변수
    static int N;
    static int [][] arr;

    // * 반 나누기 위한 방문 배열
    static boolean [] isVisited;

    // * 나눠진 팀용 -> 선수 담기/ 선수들의 방문 배열



    // * 최소 시너지 차
    static int subtraction = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 1) 입력 받기
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        isVisited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selectHalf(1,1);

        System.out.println(subtraction);
    }

    // 2) 반으로 나누기
    public static void selectHalf(int cnt, int start) {

        if(cnt > N/2){

            calculate();

            return;
        }

        for (int i = start; i <= N; i++) {
            if(!isVisited[start]){
                isVisited[start] = true;
                selectHalf(cnt+1, i+1);
                isVisited[start] = false;
            }
        }
    }


    // true 팀에서 2명을 뽑아서 시너지를 계산한 후 tureTeamAmount에 집어넣는다.
    // false 팀에서 2명을 뽑아서 시너지를 계산한 후 falseTeamAmount에 집어넣는다.

    public static void calculate() {

        int trueTeam = 0;
        int falseTeam = 0;

        for (int i = 1; i <= N -1 ; i++) {
            for (int j = i+1; j <= N; j++) {
                if( isVisited[i] && isVisited[j]){
                    trueTeam += arr[i][j] + arr[j][i];
                }

                if(!isVisited[i] && !isVisited[j]){
                    falseTeam += arr[i][j] + arr[j][i];
                }
            }
        }

        subtraction = Math.min(subtraction, Math.abs(trueTeam - falseTeam));
    }

}

