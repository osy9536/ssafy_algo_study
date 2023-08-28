package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1018 {

    static ArrayList<String> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int N,M;
    static String black = "BWBWBWBW";
    static String white = "WBWBWBWB";
    static String [] chess = new String[]{black, white};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        // 수정 횟수
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        if(N == 8 && M == 8){
            // 체스판 위가 검정일 경우
            for (int i = 0; i < N; i++) {
                if(list.get(i).equals(chess[i%2])) continue;
                else{
                    for (int j = 0; j < M; j++) {
                        if(list.get(i).charAt(j) != chess[i%2].charAt(j)){
                            cnt++;
                        }
                    }
                }
            }
            min = Math.min(cnt, min);
            cnt = 0;
            // 체스판 위가 흰색일 경우
            for (int i = 0; i < N; i++) {
                if(list.get(i).equals(chess[(i+1)%2])) continue;
                else{
                    for (int j = 0; j < M; j++) {
                        if(list.get(i).charAt(j) != chess[(i+1)%2].charAt(j)){
                            cnt++;
                        }
                    }
                }
            }
            min = Math.min(cnt, min);
            System.out.println(min);
            return;
        }

        // 검정색으로 했을 때 얼마나 바꿔야 하는지 확인

        // 초기값 넣기
        check(0,0, true);
        check(0,0,false);
        System.out.println(min);


        // 흰색으로 했을 때 얼마나 바꿔야 하는지 확인



    }

    public static void check (int vStart, int hStart, boolean isBlack) {

        int cnt = 0;

        int toggle = isBlack? 0 : 1;
        for (int x = vStart; x <= N-8; x++) {
            // i는 수평, j는 수직
            for (int i = hStart; i <= M-8; i++) {
                for (int j = x; j < 8+x; j++) {
                    // 만약 8문자가 다르면
                    if(!list.get(j).substring(i, i+8).equals(chess[toggle%2])){
                        // 다른 부분 찾아냄.
                        for (int k = 0; k < 8; k++) {
                            if(list.get(j).substring(i, i+8).charAt(k) != chess[toggle%2].charAt(k)){
                                cnt++;
                            }
                        }
                    }
                    toggle++;

                }
                min = Math.min(cnt,min);
                toggle = isBlack? 0: 1;
                cnt = 0;
            }
        }
    }


}