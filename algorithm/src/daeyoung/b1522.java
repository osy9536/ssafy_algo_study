package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 1522
 * 문자열 교환
 * 골드 5
 * https://www.acmicpc.net/problem/1522
 */
public class b1522 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ss = br.readLine();
        int aCnt = countA(ss);

        for(int i = 0; i < aCnt; i++)
            ss += ss.charAt(i);

        char[] s = ss.toCharArray();

        int bCnt = 0;
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < aCnt; i++) {
            if(s[i] == 'b')
                bCnt++;
        }

        for(int i = aCnt; i < s.length; i++) {
            if(s[i] == 'b')
                bCnt++;

            if(s[i - aCnt] == 'b')
                bCnt--;

            answer = Math.min(answer, bCnt);


        }

        System.out.println(answer);
    }

    public static int countA(String ss) {
        int cnt = 0;

        for(char c : ss.toCharArray())
            if(c == 'a')
                cnt++;

        return cnt;
    }
}
