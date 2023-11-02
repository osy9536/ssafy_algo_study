import java.util.*;

class Solution {
    static int numbers[];
    static String operations[];
    static int dp[][][];
    public int solution(String arr[]) {
        int n = arr.length/2;
        dp = new int[2][200][200];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                // dp[0]은 최댓값, dp[1]은 최솟값을 넣을거임
                dp[0][i][j] = Integer.MIN_VALUE;
                dp[1][i][j] = Integer.MAX_VALUE;
            }
        }
        
        numbers = new int[n+1];
        operations = new String[n];
        
        for(int i = 0; i < arr.length; i++){
            if(i%2 == 0){
                numbers[i/2] = Integer.parseInt(arr[i]);
            }else{
                operations[i/2] = arr[i];
            }
        }

        return calculate(0, 0, n);
    }
    static int calculate(int flag, int start, int end){
        // 자기 자신밖에 없을 때
        if(start == end){
            dp[flag][start][end] = numbers[start];
            return dp[flag][start][end];
        }

        // 이미 방문한 곳이라면 그대로 값 반환
        if(visited(flag, start, end)){
            return dp[flag][start][end];
        }

        // 방문 처리
        dp[flag][start][end] = 0;

        int res = flag == 0? Integer.MIN_VALUE:Integer.MAX_VALUE;

        // 최댓값 만들기
        if(flag == 0){
            for(int mid = start; mid < end; mid++){
                if(operations[mid].equals("-")){
                    // 최대-최소여야 값이 최대가 된다
                    res = Math.max(res, calculate(0, start, mid) - calculate(1, mid+1, end));
                }else{
                    // 최대+최대여야 값이 최대가 된다
                    res = Math.max(res, calculate(0, start, mid) + calculate(0, mid+1, end));
                }
            }
        }
        // 최솟값 만들기
        if(flag == 1){
            for(int mid = start; mid < end; mid++){
                if(operations[mid].equals("-")){
                    // 최소-최애여야 최소가 된다
                    res = Math.min(res, calculate(1, start, mid) - calculate(0, mid+1, end));
                }else{
                    // 최소+최소여야 최소가 된다 
                    res = Math.min(res, calculate(1, start, mid) + calculate(1, mid+1, end));
                }
            }
        }
        dp[flag][start][end] = res;
        return dp[flag][start][end];
    }

    static boolean visited(int flag, int start, int end){
        return dp[flag][start][end] != Integer.MIN_VALUE && dp[flag][start][end] != Integer.MAX_VALUE;
    }
}
