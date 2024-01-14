package algorithm.src.junseo;

import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        int a;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while(n!=0){
            a = n%3;
            if(a == 0) {
                a = 4;
                n/=3;
                n-=1;
            }
            else{
                n/=3;
            }
            stack.push(a);
        }
        /*
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        */
        // int형 자료를 String에 + "" 하여 더할 경우 
        // 시간이 오래 걸림 이 때 Integer 형태라면 시간이 
        // 오래 걸리지 않음 따라서 stack에서 바로 pop하여
        //  더할 경우 시간이 적게 걸림 (stack에 저장된 type은 Integer)
        int size = stack.size();
        int b;
        /*
        for(int i = 0; i<size;i++){
            b = stack.pop();
            answer += b;
        }*/
        
          for(int i = 0; i<size;i++){
            answer += stack.pop();
        }
        
        return answer;
    }
}

