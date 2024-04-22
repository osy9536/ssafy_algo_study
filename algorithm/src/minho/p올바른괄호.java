import java.util.*;
import java.io.*;

class p올바른 괄호 {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        boolean answer =true;

        int num = s.length();

        int count = 0 ;
        for(int i = 0 ; i < num; i ++){

            if(s.charAt(i)=='(') {
                count++;
                stack.add((char) s.indexOf(i));
            }
            else if(s.charAt(i)==')'){
                count--;
                if(!stack.isEmpty() && count >= 0) {
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }
        if(count != 0)
            answer = false;
        return answer;
    }
}