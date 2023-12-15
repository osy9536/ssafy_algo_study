package algorithm.src.jisu;

import java.util.*;

class p250137 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int myHeart = health;
        int p = 0;
        int continued = 0;
        
        int attackCnt = attacks.length;
        int endTime = attacks[attackCnt-1][0];
        
        for (int i = 1; i <= endTime; i++) {
            if (i == attacks[p][0]) {
                myHeart -= attacks[p][1];
                p++;
                continued = 0;
            } else {
                continued++;
                int plus = 0;
                if (continued == bandage[0]) {
                    plus = bandage[2];
                    continued = 0;
                }
                myHeart = Math.min(myHeart + bandage[1] + plus, health);
            }
            
            if (myHeart <= 0) {
                answer = -1;
                break;
            } else answer = myHeart;
        }
        return answer;
    }
}