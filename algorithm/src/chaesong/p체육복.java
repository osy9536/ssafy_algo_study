import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 잃어버린 애들 말고는 체육복이 있는 거니까
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 도난당했을 경우
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    // reserve[i]는 도난당해도 괜찮아
                    answer++; 
                    reserve[j] = -1;
                    lost[i] = -1;
                    // 다음으로 도난당한 사람은 누구?
                    break;
                }
            }
        }
        
        // 도난당한 학생에게 체육복을 빌려주는 경우
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
