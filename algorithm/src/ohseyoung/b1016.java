package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 제곱 ㄴㄴ 수
// gold 1
public class b1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int cnt = 0;
        long[] a = new long[(int) (max-min+1)];
        for(long i = 2; i*i<=max; i++) {
            long start = (min/(i*i))*i*i;
            if(start<min)start+=i*i;

            for(long j = start; j<=max;j+=i*i ){
                a[(int) (j-min)]++;
            }
        }
        for(int i = 0; i<max-min+1; i++) {
            if(a[i]==0) cnt++;
        }
        System.out.println(cnt);
    }
}

