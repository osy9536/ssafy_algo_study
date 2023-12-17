package algorithm.src.jisu;

import java.util.*;

class p181188 {
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });
        
        for (int[] arr : targets) {
            set.add(arr);
        }
        
        int base = -1;
        for (int[] arr : set) {
            // System.out.println(Arrays.toString(arr) + " " + base + " " + answer);
            if (base <= arr[0]) {
                answer++;
                base = arr[1];
            }
        }
        
        // System.out.println(set.first());
        return answer;
    }
}