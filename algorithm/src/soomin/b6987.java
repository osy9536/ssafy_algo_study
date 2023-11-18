package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6987 {

    // 팀들의 승무패 저장
    static int [][] WorldCup;
    static boolean isValid = false;


    // Match UP 에 대한 배열 같은 인덱스끼리 같이 붙는 것임
    static int[] teamOnes =         {1,1,1,1,1,2,2,2,2,3,3,3,4,4,5};
    static int[] teamAnothers =     {2,3,4,5,6,3,4,5,6,4,5,6,5,6,6};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 하나의 TC에 대해서 경우의 수 체크
        for (int T = 0; T < 4; T++) {
            boolean validWorldCup = true;
            WorldCup = new int[7][3];

            // 입력값 받기
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= 6; i++) {
                for (int j = 0; j < 3; j++) {
                    // i -> A ~ F까지의 팀, j == 0 승 / j == 1 무 / j == 2 패
                    WorldCup[i][j] = Integer.parseInt(st.nextToken());
                }
                // 한 팀의 경기 수는 무조건 5번이어야 하는데, 그거 보다 작거나 크다면 유효하지 않은 경우의 수 임으로 바로 탈락 !
                if(WorldCup[i][0]+ WorldCup[i][1] + WorldCup[i][2] != 5){
                    validWorldCup = false;
                }


            }

            if(validWorldCup == false){
                System.out.print(0+" ");
                continue;

            }

            isValid = false;
            int matchCount  = 0;
            Ingame(matchCount);

            if(isValid){
                System.out.print(1+ " ");
            }else{
                System.out.print(0+ " ");
            }

        }


    }

    // 경기 유효성 검사하는 백트래킹, 백트래킹 횟수가 15번이다. -> 그럼 유효한 경우가 있다는 소리임으로 백트래킹 끝내면 된다.
    // 백트래킹 횟수가 15번이라면 모든 팀이 서로 승패, 무무, 패승 중 하나의 경우를 나눠가졌다는 소리가 된다.
    public static void Ingame (int matchCount) {

        // 기저 조건
        if(matchCount == 15){
            isValid = true;
            return;
        }

        // 팀 두 개 선택
        int teamOne = teamOnes[matchCount];
        int teamAnother = teamAnothers[matchCount];

        // 팀 One 승, 팀 Another 패
        if(WorldCup[teamOne][0] > 0 && WorldCup[teamAnother][2] > 0){

            int newMatchCnt = matchCount+1;

            WorldCup[teamOne][0]--;
            WorldCup[teamAnother][2] --;
            Ingame(newMatchCnt);
            WorldCup[teamOne][0]++;
            WorldCup[teamAnother][2] ++;
        }

        // 팀 One 무, 팀 Another 무
        if(WorldCup[teamOne][1] > 0 && WorldCup[teamAnother][1]> 0){

            int newMatchCnt = matchCount+1;

            WorldCup[teamOne][1]--;
            WorldCup[teamAnother][1] --;
            Ingame(newMatchCnt);
            WorldCup[teamOne][1]++;
            WorldCup[teamAnother][1] ++;
        }


        // 팀 One 패, 팀 Anoter  패
        if(WorldCup[teamOne][2] > 0 && WorldCup[teamAnother][0] > 0){

            int newMatchCnt = matchCount+1;

            WorldCup[teamOne][2] --;
            WorldCup[teamAnother][0]--;
            Ingame(newMatchCnt);
            WorldCup[teamOne][2] ++;
            WorldCup[teamAnother][0] ++;
        }

    }
}
