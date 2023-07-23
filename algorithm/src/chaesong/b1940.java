package algorithm.src.chaesong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //이건 한줄 한줄씩 읽을 때
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()); //이건 한줄에 숫자 여러 개가 주어질 때
        //배열 만듦
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        //배열 정렬
        Arrays.sort(A);

        int start = 0;
        int end = N - 1;
        int cnt = 0;
        while(start < end){
            int sum = A[start] + A[end];
            if(sum < M){
                start++;
            }
            else if(sum > M){
                end--;
            }
            else if(sum == M){
                cnt++;
                start++;
                end--;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}

    //sum을 처음에 선언해놓는 게 아니라
    //start, end값에 따라 바뀌도록 while문 안에 넣었어야 했음
