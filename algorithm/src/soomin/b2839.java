package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2839 {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tracking(N,0);
        System.out.println(cnt);
    }

    public static void Tracking(int N, int count) {

        // 기저조건
        if(N ==0) {
            cnt = count;
            return;
        }

        if(N == 1 || N == 2) {
            cnt = -1;
            return;
        }


        // 유도부분
        // 5보다 크면 -5, 근데 그 결과가 -1이면 -3으로 다시 가보기, 그래도 안되면 -1 출력
        if(N>=5) {
            Tracking(N-5,count+1);
            if(cnt == -1) {
                Tracking(N-3, count+1);
                return;
            }
        }
        // 3~5 사이면 -3 으로 쭉 가보기
        if(N>=3 && N<5) {
            Tracking(N-3,count+1);
            if(cnt == -1) return;
        }


    }
}
