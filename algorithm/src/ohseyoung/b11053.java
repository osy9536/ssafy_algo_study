package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
// silver 2
public class b11053 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dp = new int[n];
        for(int i = 0 ; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0]=1;
        for(int i = 1 ; i<n; i++){
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if(arr[j]<arr[i]&&dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i : dp){
            max=Math.max(max,i);
        }
        System.out.println(max);
    }

}
