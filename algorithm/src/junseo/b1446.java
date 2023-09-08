package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class b1446 {
    static int [] dp;
    static int N,D;
    static List<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new int[D+1];

        list = new ArrayList[D+1];
        for (int i = 0; i <= D; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dis = b-a;
            if(b>D || c>dis) continue;
            list[a].add(new int[] {b,c});
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= D; i++) {
            if(i>0) dp[i] = Math.min(dp[i],dp[i-1]+1);
            for(int[] a : list[i]){
                dp[a[0]] = Math.min(dp[a[0]],dp[i]+a[1]);
            }
        }
        System.out.println(dp[D]);
    }
}


