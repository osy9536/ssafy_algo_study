import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 0;
        long r = (long) times[times.length-1] * n; // 최대로 걸리는 시간
        System.out.println(r);
        long answer = 0; 
        while(l <= r){
            long now = 0;
            long mid = (l+r) / 2;
            for(int i = 0; i < times.length; i++){
                now += mid / times[i];
            }
            if(n <= now){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
