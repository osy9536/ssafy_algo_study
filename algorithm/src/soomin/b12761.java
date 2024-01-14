package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b12761 {
    static boolean [] flag = new boolean[100001];

    static int congA, congB, DG, JM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        congA = Integer.parseInt(st.nextToken());
        congB = Integer.parseInt(st.nextToken());

        DG = Integer.parseInt(st.nextToken());
        JM = Integer.parseInt(st.nextToken());


        flag[DG] = true;

        bfs();



    }

    public static void bfs(){
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        aq1.add(DG);
        int Qsize;

        int cnt = 0;
        while(!aq1.isEmpty()) {
            Qsize = aq1.size();

            for (int i = 0; i < Qsize; i++) {
                int cur = aq1.poll();
                flag[cur] = true;

                if(cur == JM){
                    System.out.println(cnt);
                    return;
                }

                if(cur+1 <= 100000 && !flag[cur+1]){
                    aq1.add(cur+1);
                    flag[cur+1] = true;
                }
                if(cur-1>=0 && !flag[cur-1]){
                    aq1.add(cur-1);
                    flag[cur-1] = true;
                }
                if(cur+congA<=100000 && !flag[cur+congA]){
                    aq1.add(cur+congA);
                    flag[cur+congA] = true;
                }
                if(cur+congB<=100000 && !flag[cur+congB]){
                    aq1.add(cur+congB);
                    flag[cur+congB] = true;
                }
                if(cur-congA>=0 && !flag[cur-congA]){
                    aq1.add(cur-congA);
                    flag[cur-congA] = true;
                }
                if(cur-congB>=0 && !flag[cur-congB]){
                    aq1.add(cur-congB);
                    flag[cur-congB] = true;
                }

                if(cur*congA<=100000 && !flag[cur*congA]){
                    aq1.add(cur*congA);
                    flag[cur*congA] = true;
                }
                if(cur*congB<=100000 && !flag[cur*congB]){
                    aq1.add(cur*congB);
                    flag[cur*congB] = true;
                }



            }
            cnt++;
        }
    }
}
