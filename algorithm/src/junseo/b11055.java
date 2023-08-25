package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11055 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N+1];
        int [] dp  = new int [N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 1;i<=N;i++){
            dp[i] = arr[i];
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}

