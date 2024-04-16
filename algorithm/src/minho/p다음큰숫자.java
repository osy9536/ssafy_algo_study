import java.io.*;
import java.util.*;

class p다음큰숫자 {
    public int solution(int n) {
        int answer = 0;
        boolean find = false;
        answer = n;
        int count = 0,anscnt;
        count = Integer
                .toBinaryString(n)
                .replace("0","")
                .length();
        while(true){
            if(find) break;
            answer += 1;
            anscnt = Integer
                    .toBinaryString(answer)
                    .replace("0","")
                    .length();
            if(count==anscnt){
                find = true;
            }

        }

        return answer;
    }
}