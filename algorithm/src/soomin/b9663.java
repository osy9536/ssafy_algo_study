package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9663 {

    // N-Queen 문제
    // : 체스 퀸을 서로 공격하지 못하는 장소로 놔둬라
    static int N;

    // N퀸 성공한 경우의 수
    static int cnt;
    // 열 체커
    static boolean [] isVisitedX;

    // 오른쪽 대각선 체커
    static boolean [] isVisitedR;

    // 왼쪽 대각선 체커
    static boolean [] isVisitedL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isVisitedX = new boolean[N];
        isVisitedR = new boolean[2*N];
        isVisitedL = new boolean[2*N];

        recur(0);
        System.out.println(cnt);
    }

    // x는 행, y는 열
    public static void recur( int x) {

        if(x== N){
            cnt++;
        }

        // i는 열번호
        for (int i = 0; i < N; i++) {

            // 만약 하나라도 못 지키면, 다음 i를 봐야함. (방문 배열 true, false 값 건드리면 안된다.)

            // 열 체킹
            if(!isVisitedX[i]) {
                isVisitedX[i] = true;
                // 왼 하단 -> 우 상단 체킹
                if(!isVisitedR[i+x]) {
                    isVisitedR[i+x] = true;
                    // 오 하단 -> 왼 상단 체킹
                    if(!isVisitedL[i-x +(N-1)]) {
                        // 체크 모두 성립하면 다음 재귀로 넘어감
                        isVisitedL[i-x +(N-1)] = true;
                        recur(x+1);

                        isVisitedL[i-x +(N-1)] = false;
                    }
                    isVisitedR[i+x] = false;
                }

                // 재귀에서 나와선 아까 체크 했던 것 모두 원 상 복귀
                isVisitedX[i] = false;
            }
        }

    }
}
