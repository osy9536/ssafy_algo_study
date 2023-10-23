package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


/* 11811 데스스타
 * ai와 aj의 비트 and 연산으로 이루어진 arr[ai][aj]가 주어졌을 때,
 * ai의 수열을 구해라
 * */

/*  문제 풀이 방법
 * 	and 연산이므로, 될 수 있는 가능한 값은, 그 행에서 가장 큰 값이다. and 비트 연산은 완전히 같은 값만 살아남음으로,
 * */

public class b11811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int [N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] now : arr) {
            sb.append(Arrays.stream(now).max().orElse(0)).append(" ");
        }

        System.out.println(sb);
    }

}