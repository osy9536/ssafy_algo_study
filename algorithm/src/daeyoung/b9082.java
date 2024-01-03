package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 9082
 * 지뢰찾기
 * 골드 4
 * https://www.acmicpc.net/problem/9082
 */
public class b9082 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); //testCase

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //배열의 크기

            char[] num = br.readLine().toCharArray();
            char[] mine = br.readLine().toCharArray();

            int len = num.length;
            int answer = 0;

            if(len % 3 == 1) {
                for(int i = 0; i < len; i += 3)
                    answer += Integer.parseInt(num[i] + "");
            } else {
                for(int i = 1; i < len; i += 3)
                    answer += Integer.parseInt(num[i] + "");
            }

            System.out.println(answer);
        }

    }

}


