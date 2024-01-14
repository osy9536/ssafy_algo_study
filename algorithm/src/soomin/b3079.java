package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
*   제일 오래 걸리는 시간을 제일 빠른 심사대에 모두 몰린 경우로 하니 통과 되었음.
*   그 전까지는 제일 오래 걸리는 시간을 제일 느린 심사대에 모두 몰린 경우로 계산하였는데,
*   그 경우 Overflow가 나서 제대로된 이분탐색이 이루어지지 않은 것으로 파악됨.
*   여기서는 그 -21~~이란 억대단위 수와 start = 0 사이에서 이분탐색이 작동하긴 하니, overflow라는 error가 안 뜨고,
*   틀렸습니다가 계속 떴던 것으로 파악됨.
* */

public class b3079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N -> 심사대 개수, M -> 사람 수
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long []checkPoint = new long[N];

        // slow 는 심사대 중 가장 오래 걸리는 시간을 저장
        int slow = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int value =Integer.parseInt(br.readLine());
            checkPoint[i] = value;
            slow = Math.min(slow, value);
        }

        // 입국 심사대에서 걸리는 최악의 시간
        long max = slow*(M);
        long min = 0;

        // mid: 걸리는 시간의 중간값
        long mid;

        while(min <= max){
            mid = (max+min)/2;

            // cnt: 해당 중간값 시간 동안 심사 끝나는 사람의 수
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += mid/checkPoint[i];
            }

            // 통과하는 사람이 내 친구들 수보다 크다 -> 필요한 시간에 비해 잉여시간이 많다.
            if(cnt >= M){
                max = mid-1;

            }else{
                min = mid +1;
            }
        }

        System.out.println(min);
    }
}