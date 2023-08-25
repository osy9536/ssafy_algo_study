package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17281 {
    static int N;
    static int[][] HITS;
    static int [] LINE_UPS = new int[10];
    static boolean [] flag  = new boolean[10];


    // 최대 득점 수
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        HITS = new int[N+1][10];


        // 이닝별 1~9번 선수 Hit 현황 기록
        for (int inning = 1; inning <= N; inning++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 10; i++) {
                HITS[inning][i] = Integer.parseInt(st.nextToken());
            }
        }

        flag[1] = true;
        Permutation(1);
        System.out.println(max);
    }




    public static void Permutation(int deepth){

        if(deepth == 4){
            LINE_UPS[4] = 1;
            Permutation(deepth+1);
        }

        if(deepth == 10){
            playBaseBall();
            return;
        }

        for (int i = 1; i <= 9 ; i++) {
            if (flag[i]) continue;

            flag[i] = true;
            LINE_UPS[deepth] = i;
            Permutation(deepth+1);
            flag[i] = false;
        }
    }


    public static void playBaseBall(){

        // 1이닝에 9명 전부 다 칠수도 있고, 이닝 끝나고도, 다음 타자 기억해야함으로 선발타자 기억 해둔다.

        int starter = 0;
        int out = 0;
        int score = 0;
        boolean [] ru = new boolean[4];

        for (int inning = 1; inning <= N; inning++) {
            while(out !=3 ){
                starter++;
                if(starter >9) starter %= 9;
                int curHIT = HITS[inning][LINE_UPS[starter]];

                switch (curHIT){
                    case 0: {
                        out++;
                        break;
                    }
                    case 1:{
                        if(ru[3]) score++;
                        ru[3] = ru[2];
                        ru[2] = ru[1];
                        ru[1] = true;
                        break;
                    }

                    case 2:{
                        if(ru[3]) score++;
                        if(ru[2]) score++;
                        ru[3] = ru[1];
                        ru[2] = true;
                        ru[1] = false;
                        break;
                    }


                    case 3:{
                        if(ru[3]) score++;
                        if(ru[2]) score++;
                        if(ru[1]) score++;
                        ru[3] = true;
                        ru[2] = false;
                        ru[1] = false;
                        break;
                    }


                    case 4:{
                        if(ru[3]) score++;
                        if(ru[2]) score++;
                        if(ru[1]) score++;
                        score++;
                        ru[3] = false;
                        ru[2] = false;
                        ru[1] = false;
                        break;
                    }

                }
            }
            for (int i = 1; i <= 3; i++) {
                ru[i] =false;
            }
            out = 0;

        }
        max = Math.max(max,score);
    }


}
