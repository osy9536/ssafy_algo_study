import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    static int len = 0;
    static int goal = 0;
    static int arr[];
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        goal = target;
        arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = numbers[i];
        }
        dfs(0, -arr[0]);
        dfs(0, arr[0]);
        return answer;
    }
    static void dfs(int depth, int now){
        if(depth >= len-1){
            if(now == goal){
                answer++;
            }
            return;
        }
        dfs(depth+1, now-arr[depth+1]);
        dfs(depth+1, now+arr[depth+1]);
    }
}
