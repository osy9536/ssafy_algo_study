import java.util.*;

class p카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int totalSum = brown+yellow;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 3 ; i <= totalSum/2; i++ ){
            if(totalSum%i == 0){
                if(((totalSum/i*2)+(i*2)-4) == brown){
                    answer[0] = i;
                    answer[1] = totalSum/i;
                }
            }
        }
        return answer;
    }
}