package Programmers;

import java.util.*;

class p124나라의숫자 {
    public String solution(int n) {
        Stack<Integer> stack = new Stack <>();
        String answer = "";
        while(n != 0) {
            int temp = n % 3;
            
            if(temp == 0) {
                temp = 4;
                n = n / 3 - 1;
            } else {
                n /= 3;
            }
            stack.push(temp);
        }
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        return answer;
    }
}
