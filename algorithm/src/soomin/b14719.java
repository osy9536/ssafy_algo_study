package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int [] arr = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int startX = -1;

        // i는 최고 높이부터 밑으로 내려 오는 수
        // j는 가로로 훑는 반복자
        for (int i = H; i >= 1; i--) {
            for (int j = 0; j < W; j++) {

                // arr[j]자리의 높이가 현 확인중인 높이이고, 아직까지 해당 높이의 다른 벽을 만난 적이 없다면, startx에 해당 가로 위치 저장
                if(arr[j] == i && startX == -1){
                    startX = j;
                    arr[j]--;
                }
                // 두번째로 해당 높이의 벽을 만났다면
                else if(arr[j] == i && startX !=-1){
                    cnt += j - startX-1;
                    startX = j;
                    arr[j]--;
                }
            }
            startX = -1;
        }


        System.out.println(cnt);


    }
}
