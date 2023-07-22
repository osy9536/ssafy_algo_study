package algorithm.src.chaesong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //합배열 만들기
        long sum[] = new long[N];
        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        } //힙배열 완성

        //합배열의 나머지 배열 구하기
        long nanugi[] = new long[M];
        long ans = 0;
        for (int i = 0; i < N; i++) {
            int remainder = (int)(sum[i] % M);
            //정답(1)_0~i까지 합 중 나머지가 0인 경우
            if (remainder == 0) {
                ans++;}
            //정답(2)_부분합 중 나머지가 같은 인덱스 추출
            nanugi[remainder]++;
        }

        //정답(2)_나머지가 같은 인덱스 중 2개 고르기
        for (int i = 0; i < M; i++) {
            if (nanugi[i] > 0) {
                ans += (nanugi[i] * (nanugi[i] - 1) / 2);
            }
        }
        System.out.println(ans);
        }
}
