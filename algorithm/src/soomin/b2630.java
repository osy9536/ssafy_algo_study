package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2630 {

    static int BLUE = 0;
    static int WHITE = 0;
    static StringBuilder [] sbs;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sbs = new StringBuilder[N];

        for(int i = 0; i < N; i++ ) {
            sbs[i] = new StringBuilder(br.readLine().replace(" ", ""));
        }

        DVC(0,0,N);
        System.out.println(WHITE);
        System.out.println(BLUE);
    }

    public static void DVC(int x, int y, int size) {

        StringBuilder onejudge = new StringBuilder();
        StringBuilder zerojudge = new StringBuilder();

        for(int i = 0; i< size; i++) {
            onejudge.append(1);
            zerojudge.append(0);
        }

        int oneCnt =0;
        int zeroCnt = 0;
        //자기 자신의 크기 만큼 맞는지 아닌지 확인
        for(int i = x; i < x+size; i++) {
            String experiment = sbs[i].substring(y, y+size);
            if(experiment.equals(String.valueOf(onejudge))) {
                oneCnt++;
            }
            if(experiment.equals(String.valueOf(zerojudge))) {
                zeroCnt++;
            }
        }
        if(oneCnt == size) {BLUE++; return;}
        else if(zeroCnt == size) {WHITE++; return;}
        else {
            // 1,2,3,4 분면 이동
            int []idx = {0,0,size/2,size/2};
            int []idy = {0,size/2,0,size/2};

            DVC(x,y,size/2);
            DVC(x,y+size/2,size/2);
            DVC(x+size/2,y,size/2);
            DVC(x+size/2,y+size/2, size/2);
            return;
        }
    }
}
