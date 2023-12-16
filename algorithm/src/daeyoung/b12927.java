package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 12927
 * 배수 스위치
 * 실버 4
 * https://www.acmicpc.net/problem/12927
 */
public class b12927 {

    static char[] light;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        light = br.readLine().toCharArray();

        int answer = 0;

        for(int i = 0; i < light.length; i++) {
            if(isOff())
                break;
            if(light[i] == 'Y')
                answer += off(i + 1);
        }

        System.out.println(answer);
    }

    public static int off(int index) {

        for(int i = 1; i < light.length / index + 1; i++) {
            if(light[i * index - 1] == 'Y')
                light[i * index - 1] = 'N';
            else
                light[i * index - 1] = 'Y';
        }

        return 1;
    }

    public static boolean isOff() {
        for(char c : light) {
            if(c == 'Y')
                return false;
        }

        return true;
    }
}
