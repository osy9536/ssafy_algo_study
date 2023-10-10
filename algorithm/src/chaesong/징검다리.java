import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;
        
        int l = 1; int r = distance;
        while(l <= r){
            int mid = (l+r) / 2;
            if(removedRocks(rocks, mid, distance) <= n){
                answer = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return answer;
    }
    public int removedRocks(int rocks[], int mid, int end){
        int cnt = 0; int before = 0;
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i]-before < mid) {
                cnt++;
            }else{
                before = rocks[i];
            }
        }
        if(end-before < mid) cnt++;
        return cnt;
    }
}
