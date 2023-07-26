package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1018 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];

        int i, j, k, n, m;
        for (i = 0; i < N; i++) {
            String str = br.readLine();
            for (j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        //////////////////////////////////////////////////////////////////////////
        char[] BW = {'B', 'W'};
        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < 2; i++) {
            char start = BW[i];
            ////////////////////////////////////////////////////////////////////////
            for (j = 0; j <= N - 8; j++) {            //세로
                for (k = 0; k <= M - 8; k++) {     //가로
                    cnt = 0;

                    for (n = 0; n < 8; n++) {      //8x8세로
                        if (start == 'B') start = 'W';
                        else start = 'B';

                        for (m = 0; m < 8; m++) {    //8x8가로
                            if (n == 0 && m == 0) {//8x8의 맨 왼쪽 맨위
                                if (arr[j + n][k + m] != start) cnt++; //시작 색깔과 다르면 cnt++하고 시작
                            } else {
                                if (arr[j + n][k + m] != start) {
                                    start = arr[j + n][k + m];
                                    continue;
                                } else {
                                    if (start == 'B') start = 'W';
                                    else start = 'B';
                                    cnt++;
                                }
                            }

                        }
                    }
                    ans = Math.min(ans, cnt);
                }
            }
        }
        System.out.println(ans);
    }
}