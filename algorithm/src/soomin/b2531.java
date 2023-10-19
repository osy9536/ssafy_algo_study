package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


/* 2531번 회전 초밥
 * N개의 초밥접시, d개의 초밥 가짓수가 주어진다.
 * 현 초밥이터가 연속해서 먹을 수 있는 초밥의 개수는 k개 이다.
 * 쿠폰이 하나 주어진다. 쿠폰 번호는 c이고, 해당 넘버의 초밥을 무료로 먹을 수 있다.
 * 초밥이터가 먹을 수 있는 초밥의 최대 가짓수는?
 * */

/*  문제 풀이 방법
 * 	방문 배열과 투포인터로 푼다.
 * 	초기 값들과 쿠폰 번호에 해당하는 스시는 방문 상태로 만든다. 그리고 그 가짓수를 센다.
 *  투포인터를 이동시켜서 맨 앞 대가리 스시는 미방문 상태로 돌리고, 꼬리로 들어오는 스시의 방문 상태는 올린다. 그리고 가짓수를 센다.
 *  최대 가짓수를 출력한다.
 * */

public class b2531 {

    static int N,d,k,c;
    static int [] isVisited;
    static ArrayDeque<Integer> conveyorbelt = new ArrayDeque<>();
    static ArrayDeque<Integer> eating		= new ArrayDeque<>();
    //가짓수
    static int eatingCnt = 1;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        isVisited = new int [d+1];

        for (int i = 0; i < N; i++) {
            conveyorbelt.add(Integer.parseInt(br.readLine()));
        }

        // 초기값 설정
        isVisited[c]  = 1;


        for (int i = 0; i < k; i++) {
            int curSushi = conveyorbelt.poll();
            eating.add(curSushi);

            if(isVisited[curSushi]==0) {
                eatingCnt++;
            }
            isVisited[curSushi]++;

        }



        for (int i = 0; i < N+1; i++) {
            int out = eating.poll();
            conveyorbelt.add(out);
            isVisited[out]--;
            if(isVisited[out] == 0) {
                eatingCnt--;
            }

            int in = conveyorbelt.poll();
            eating.add(in);
            if(isVisited[in] == 0) {
                eatingCnt++;
            }
            isVisited[in]++;

            max = Math.max(eatingCnt, max);


        }

        System.out.println(max);





    }

}