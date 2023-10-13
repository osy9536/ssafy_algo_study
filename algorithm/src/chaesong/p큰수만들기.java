import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder answer = new StringBuilder("");
        int len = number.length()-k; // 뽑아야 하는 개수
        int start = 0; 
        
        for(int i = 0; i < len; i++){
            int max = 0;
            for(int j = start; j <= k+i; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    start = j+1; // 하나 뽑고 나면 뒤에서부터 시작
                }
            }
            answer.append(max);
        }
        
        return answer.toString();
    }
}
