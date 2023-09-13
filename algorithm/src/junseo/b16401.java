package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen,arr[i]);
        }
        int left = 1;
        int right = maxLen;
        int ans = 0;
        while(left<=right){
            int mid = (left+right) /2 ;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += arr[i]/mid;
            }
            if(cnt>=M){
                ans = mid;
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }
        System.out.println(ans);

    }
}

