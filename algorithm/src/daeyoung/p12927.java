package algorithm.src.daeyoung;

import java.util.*;

/**
 * 프로그래머스 - 야근 지수
 * Lv 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
public class p12927 {

    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};

        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        for(int i : works)
            pq.add(i);

        while(n != 0) {
            int cur = pq.poll();

            if(cur == 0)
                break;

            cur -= 1;
            n -= 1;
            pq.add(cur);
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            answer += cur * cur;
        }

        System.out.println(answer);
    }
}
