package algorithm.src.jisu;

import java.util.*;

class p250121 {
    class Sort implements Comparable<Sort> {
        int idx, data;
        public Sort(int idx, int data) {
            this.idx = idx;
            this.data = data;
        }
        public int compareTo(Sort s) {
            return this.data - s.data;
        }
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] column = {"code", "date", "maximum", "remain"};
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (String str : column) {
            map.put(str, cnt++);
        }
        
        List<Sort> list = new ArrayList<>();
        cnt = -1;
        for (int[] arr: data) {
            cnt++;
            if (arr[map.get(ext)] >= val_ext) continue;
            list.add(new Sort(cnt, arr[map.get(sort_by)]));
        }
        
        Collections.sort(list);
        
        int[][] answer = new int[list.size()][4];
        cnt = 0;
        for (Sort s : list) {
            answer[cnt++] = data[s.idx];
        }
        
        return answer;
    }
}