package algorithm.src.soomin;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.math.BigInteger;

import java.util.ArrayDeque;

import java.util.Arrays;

import java.util.StringTokenizer;

/* 2096번 내려가기
 *  3열 N행 행렬이 주어지는데, 1행에서 값을 선정해서 점차 내려갈 것이다. (내려가는 방법은 문제 참조)
 *  이때, 내려가면서 만나는 숫자는 모두 더한다.
 *  N행에 도착했을 때 얻을 수 있는 최대값과 최소값을 구하라
 * */

/* 문제 풀이 방법
 *   DP로 가닥을 잡았다.
 *   최대값 구하는 DP 2차원 행렬과 최소값 구하는 DP 2차원 행렬 2개를 나눠서 생각한다.
 *   최대값은 모두 0으로 채우고, 최소값은 모두 MAX_VALUE로 채운다.
 *   최대값 점화식은 DP[i][j] = MAX (DP[i-1][j-1], DP[i-1][j], DP[i-1][j+1]) + arr[i][j]
 *   최소값 점화식은 DP[i][j] = MIN (DP[i-1][j-1], DP[i-1][j], DP[i-1][j+1]) + arr[i][j]
 * */

public class b2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N+1][5];
        // 최대값 DP 용, 최소값 DP 용
        int [][] MAX = new int[N+1][5];
        int [][] MIN = new int[N+1][5];

        // 최소값 구하는 식은 전부 MAX_VALUE로 채워준다.
        for (int i = 0; i <=N; i++) {
            Arrays.fill(MIN[i], Integer.MAX_VALUE-20);
        }

        for (int i = 0; i <=N; i++) {
            Arrays.fill(MAX[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 행 값 세팅
        MAX[1][1] = arr[1][1];
        MAX[1][2] = arr[1][2];
        MAX[1][3] = arr[1][3];

        MIN[1][1] = arr[1][1];
        MIN[1][2] = arr[1][2];
        MIN[1][3] = arr[1][3];

        //최대값, 최소값 DP 각각 진행
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 4; j++) {
                MAX[i][j] = Math.max(MAX[i-1][j-1], Math.max(MAX[i-1][j], MAX[i-1][j+1])) + arr[i][j];
                MIN[i][j] = Math.min(MIN[i-1][j-1], Math.min(MIN[i-1][j], MIN[i-1][j+1])) + arr[i][j];
            }
        }

//        System.out.println("MAX---------");
//        for (int[] temp :
//                MAX) {
//            System.out.println(Arrays.toString(temp));
//        }
//        System.out.println("MIN---------");
//        for (int[] temp :
//                MIN) {
//            System.out.println(Arrays.toString(temp));
//        }

        System.out.println(Arrays.stream(MAX[N]).max().orElse(-1) + " " + Arrays.stream(MIN[N]).min().orElse(-1));


    }

}
