package algorithm.src.soomin;
import java.util.*;
import java.io.*;

public class b18111{

    static int[][] mine;

    // 현재 만들려고 하는 기준 높이
    static int curH = 0;

    // 원래 토지 부분에서 가장 높이가 높은 부분
    static int maxH = 0;

    // 현재 만들려는 높이를 만들었을 때 걸리는 시간
    static int time = 0;

    // 답이 되는 최소 시간
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        mine = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++) {
                mine[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, mine[i][j]);
            }
        }

        curH = maxH;

        // 정상 종료가 아님에 대한 신호탄
        boolean valid = false;
        while(true) {
            int block = B;
            loopout:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <M; j++) {
                    if(mine[i][j] > curH) {
                        time += (mine[i][j] - curH)*2;
                        block += (mine[i][j] - curH);
                    }
                    else if(mine[i][j] < curH) {
                        time  += 	(curH - mine[i][j]);
                        block -= 	(curH - mine[i][j]);
                    }
                }
            }

            if(block < 0) {
                valid = true;
            }

            // 정상 종료가 아닐 경우 기준 높이를 1깎고 다시 시작
            if(valid) {
                curH--;
                time = 0;
                valid = false;
                continue;
            }

            if(time < minTime) {
                minTime = time;
            }else {
                break;
            }
            curH--;
            time = 0;
        }


        System.out.println(minTime + " " + (curH+1));


    }
}
