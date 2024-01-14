package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] cnt = new int[100010];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int start = 0;
        int max = 0;
        while(end<N){
            cnt[arr[end]]++;
            while(cnt[arr[end]]>K){
                cnt[arr[start]]--;
                start++;
            }
            max = Math.max(max,end-start+1);
            end++;
        }
        System.out.println(max);
    }
}


