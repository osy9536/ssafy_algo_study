package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17266
 * 어두운 굴다리
 * 실버4
 * https://www.acmicpc.net/problem/17266
 */
public class b17266 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //굴다리 길이
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        //가로등 개수
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] location = new int[m];

        //설치할수 있는 가로등 위치
        for (int i = 0; i < m; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        int max = location[0];
        int start = 0;

        for(int i = 1; i < m; i++) {
            //짝수
            int i1 = location[i] - location[i - 1];
            if((i1 & 1) == 0 )

                max = Math.max(max, i1 / 2);
            else
                max = Math.max(max, i1 / 2 + 1);
        }

        max = Math.max(max, n - location[m - 1]);

        System.out.println(max);
    }

}
