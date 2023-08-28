package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b15961 {

    private static final String ArrayDeque = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        java.util.ArrayDeque<Integer> rotating = new ArrayDeque<>();
        ArrayDeque<Integer> eating = new ArrayDeque<>();

        // cnt -> 초밥 가짓수에 맞게 ++, max -> 초밥 가짓수가 최대일 경우 갱신
        int max = 0;
        int cnt = 0;

        // 연속으로 먹는 초밥 접시들 중에서 쿠폰에 있는 초밥 포함인지 아닌지.
        boolean isincludedC = false;



        // 접시의 수 N, 초밥 가짓수 d, 내가 연속해서 먹을 초밥의 접시 수 k, 쿠폰 번호 c
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 모든 초밥을 만들기. -> 나온 초밥은 ++, 빠져나간 초밥은 --
        int [] sushi = new int [d+1];
        int [] eatNow = new int [k];


        // queue로 회전초밥의 회전을 구현
        for(int i = 0; i < N; i++) {
            rotating.add(Integer.parseInt(br.readLine()));
        }

        // 첫 초밥 회전으로 초밥 배열 초기화
        // 회전초밥용 큐는 계속 돌아가고
        // eating이라는 queue는 현재 먹고 있는 녀석들이 들어간다.
        for(int i = 0; i < k; i++) {
            int eat = rotating.pollFirst();
            if(sushi[eat] == 0) cnt++;
            if(eat == c) isincludedC = true;
            sushi[eat]++;
            eating.add(eat);
        }

        if(!isincludedC) max = cnt+1;
        else max = cnt;




        // 두번째 경우 부터는 맨 앞 쪽에서 하나 제거 후 쿠폰 검사, 맨 뒤쪽에 하나 넣고 쿠폰 검사
        for(int i =0; i< N; i ++) {
            int out = eating.pollFirst();
            if(--sushi[out] == 0) cnt--;
            if(sushi[out] == 0 && out == c) isincludedC = false;
            rotating.addLast(out);

            int in = rotating.pollFirst();
            if(sushi[in] == 0) cnt++;
            sushi[in]++;
            if(sushi[in] == 1 && in == c) isincludedC = true;
            eating.add(in);


            if(!isincludedC) max = Math.max(max, cnt+1);
            else max = Math.max(max, cnt);

        }

        System.out.println(max);



    }
}
