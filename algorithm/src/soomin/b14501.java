package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b14501 {

    static int sum, N;
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean [] flag;
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list.add(0, null);
        flag = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int remainedDay = N-i;
            int Time = Integer.parseInt(st.nextToken());
            int Pay = Integer.parseInt(st.nextToken());

            if(remainedDay - Time+1 < 0) {
                int [] pair = {-1, 0};
                list.add(pair);
                continue;
            };

            int [] pair = {Time,Pay};
            list.add(pair);

        }

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] == -1){
                flag[i] = true;
            }
        }

        calcul(1);
        System.out.println(max);
    }

    // true - 방문, false - 미방문
    public static void calcul(int index){

        if(index >= list.size()){
            max = Math.max(max, sum);
            return;
        }

        // 마지막 도달 했는데, 거기가 유효하지 못한 거면, 다음 날로 넘어간다.
        if(list.get(index)[0] == -1){
            calcul(index+1);
            return;
        }


        for (int i = index; i < list.size(); i++) {

            // 일자 중에 이미 시간적 할애가 잔존하는 시간보다 큰 경우는 true로 바꿨었다. 따라서
            // 현재 index보다 큰 값 중 true 인 것은 유효하지 않은 상담 시간을 가진 날이라서 그 날은 휴식하고 넘어간다.
            if(flag[i]) continue;

            // 해당 일자 상담에 필요한 시간 만큼 true (사용한 날)로 바꾼다.
            for (int j = i; j < list.get(i)[0]+i; j++) {
                // 유효하지 않은 날은 건드리지 않음
                if(list.get(j)[0] == -1) continue;
                flag[j] = true;
            }
            // 해당 일자 상담으로 받은 돈을 기록한다.
            sum += list.get(i)[1];
            calcul(list.get(i)[0]+i);

            // 해당 일자 상담을 하지 않은 경우를 check하기 위해 전부 false로 바꾼다.
            for (int j = i; j < list.get(i)[0]+i; j++) {
                if(list.get(j)[0] == -1) continue;
                flag[j] = false;
            }

            sum -=list.get(i)[1];
            calcul(i+1);
            return;
        }
    }
}
