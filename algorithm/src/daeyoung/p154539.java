package algorithm.src.daeyoung;

import java.util.Arrays;
import java.util.Stack;

/**
 * 프로그래머스 - 뒤에 있는 큰 수 찾기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
public class p154539 {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        int len = numbers.length;
        int[] answer = new int[len];

        Stack<Integer> s = new Stack<>();

        for(int i = len - 1; i >=0; i--) {
            while(!s.isEmpty()) {
                if(numbers[i] < numbers[s.peek()]) {
                    answer[i] = numbers[s.peek()];
                    break;
                }
                s.pop();
            }

            if(s.isEmpty())
                answer[i] = -1;
            s.add(i);
        }


        System.out.println(Arrays.toString(answer));
    }
}
