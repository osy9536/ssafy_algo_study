package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b12891 {

    static int S, P;
    static int cnt = 0;
    static String strings;
    static int [] min_condition;
    static int [] cur_condition = new int[4];

    // 문자열 순회하면서 값 받는 녀석
    static Deque<Character> dq = new ArrayDeque<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        // 전체 문자열 및 부분 문자열의 길이
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        //문자열 받기
        strings = br.readLine();

        // 최소 조건 받기
        st = new StringTokenizer(br.readLine());
        min_condition = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

        // 초기값 점검

        //1. 초기값 넣기
        for(int i = 0; i < P; i++){
            dq.add(strings.charAt(i));
            //2. 초기에 A C G T 중 몇 개 나 들고 있는지 check
            switch (strings.charAt(i)){
                case 'A':
                    cur_condition[0] = cur_condition[0]+1;
                    break;
                case 'C':
                    cur_condition[1] = cur_condition[1]+1;
                    break;
                case 'G':
                    cur_condition[2] = cur_condition[2]+1;
                    break;
                case 'T':
                    cur_condition[3] = cur_condition[3]+1;
                    break;
            }
        }

        // 초기값이 최소 보장 조건과 맞는지 비교
        cnt++;
        for (int i = 0; i < 4; i++) {


            if(cur_condition[i] < min_condition[i]) {
                cnt--;
                break;
            }
        }
        check(0);
        System.out.println(cnt);
    }

    public static void check(int index){

        if(P+index == S){
            return;
        }
        // 앞에 하나 빼기
        char dump = dq.pollFirst();
        switch (dump){
            case 'A':
                cur_condition[0] = cur_condition[0]-1;
                break;
            case 'C':
                cur_condition[1] = cur_condition[1]-1;
                break;
            case 'G':
                cur_condition[2] = cur_condition[2]-1;
                break;
            case 'T':
                cur_condition[3] = cur_condition[3]-1;
                break;
        }

        // 뒤에 하나 넣기
        dq.add(strings.charAt(P+index));
        switch (strings.charAt(P+index)){
            case 'A':
                cur_condition[0] = cur_condition[0]+1;
                break;
            case 'C':
                cur_condition[1] = cur_condition[1]+1;
                break;
            case 'G':
                cur_condition[2] = cur_condition[2]+1;
                break;
            case 'T':
                cur_condition[3] = cur_condition[3]+1;
                break;
        }
        cnt++;
        // 유효성 검사
        for (int i = 0; i < 4; i++) {

            if(cur_condition[i] < min_condition[i]) {
                cnt--;
                break;
            }
        }
        check(index+1);

    }
}

