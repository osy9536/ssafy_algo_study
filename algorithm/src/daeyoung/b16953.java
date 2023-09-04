package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16953
 * A -> B
 *  실버 2
 * https://www.acmicpc.net/problem/16953
 */
public class b16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 1;

        while(b > a) {
            if(b % 10 == 1) {
                b /= 10;
                cnt++;
            } else if(b % 2 == 0) {
                b /= 2;
                cnt++;
            }
            else
                break;
        }

        if(b == a)
            System.out.println(cnt);
        else
            System.out.println(-1);

    }


}
