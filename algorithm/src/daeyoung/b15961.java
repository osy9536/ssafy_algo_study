package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 15961
 * 회전초밥
 * 골드 4
 * https://www.acmicpc.net/problem/15961
 */
public class b15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); //초밥의 가지 수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹은 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        int[] dish = new int[n];
        for (int i = 0; i < n; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 1; i <= d; i++) {
            m.put(i, 0);
        }

        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++) {
            if(m.get(dish[i]) == 0)
                count++;
            m.put(dish[i], m.get(dish[i]) + 1);
        }

        if(m.get(c) == 0) {
            count++;
            max = count;
            count--;
        } else {
            max = count;
        }
        for(int i = k; i < n + k; i++) {
            m.put(dish[i - k], m.get(dish[i - k]) - 1);
            if(m.get(dish[i - k]) == 0)
                count--;

            if(m.get(dish[i % n]) == 0)
                count++;
            m.put(dish[i % n], m.get(dish[i % n]) + 1);

            if(m.get(c) == 0) {
                count++;
                if(max < count)
                    max = count;
                count--;
            } else {
                if(max < count)
                    max = count;
            }

        }

        System.out.println(max);

    }
}
/*
1. 임의의 위치에서 k개 연속으로 먹으면 할인
2. 쿠폰 하나 발급, 1번 행사 참가할 경우 초밥 하나 추가로 무료 제공

초밥 종류 최대값 구하기
 */
