package algorithm.src.jisu;

import java.util.*;

class p258712 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        int[][] lastMonth = new int[friends.length][friends.length];
        int[] present = new int[friends.length];
        int[] result = new int[friends.length];
        
        int cnt = 0;
        for (String str : friends) {
            map.put(str, cnt++);
        }
        
        for (String str : gifts) {
            String[] giveNtake = str.split(" ");
            int giver = map.get(giveNtake[0]);
            int taker = map.get(giveNtake[1]);
            lastMonth[giver][taker]++;
            present[giver]++;
            present[taker]--;
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                int gave = lastMonth[i][j];
                int took = lastMonth[j][i];
                if (gave > took) result[i]++;
                else if (gave == took && present[i] > present[j]) result[i]++;
            }
            if (result[i] > answer) answer = result[i];
        }
        
        return answer;
    }
}