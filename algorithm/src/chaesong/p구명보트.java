import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int idx = 0; // 몸무게 가장 적게 나가는 사람
        
        for(int i = people.length-1; i >= idx; i--){
            // 많은 사람이랑 태워서 보내면 됨
            if(people[i] + people[idx] <= limit){ 
                idx++;
                answer++;
            }
            // 못 태우면 혼자 보내야 해 
            else{
                answer++;
            }
        }
        return answer;
    }
}
