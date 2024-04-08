package algorithm.src.daeyoung;

import java.util.*;

/**
 * 프로그래머스 - 롤케이크 자르기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class p132265 {

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer = 0;
        int[] check1 = new int[10001];
        int kind1 = 0;
        
        for(int i : topping) {
            if(check1[i] == 0)
                kind1++;
            check1[i] += 1;
        }
        
        int[] check2 = new int[10001];
        int kind2 = 0;
        
        for(int i : topping) {
            check1[i]--;
            if(check1[i] == 0)
                kind1--;
            
            if(check2[i] == 0)
                kind2++;
            check2[i]++;
            
            
            if(kind1 == kind2)
                answer++;
        }
    }
}
