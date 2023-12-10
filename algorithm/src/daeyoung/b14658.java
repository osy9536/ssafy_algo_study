package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 14658
 * 하늘에서 별똥별이 빗발친다
 * 골드 3
 * https://www.acmicpc.net/problem/14658
 */
public class b14658 {

    static class Star {
        int x;
        int y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //별똥별이 떨어지는 구역의 가로 길이
        int m = Integer.parseInt(st.nextToken()); //별똥별이 떨어지는 구역의 세로 길이
        int l = Integer.parseInt(st.nextToken()); //트램펄린 한변의 길이
        int k = Integer.parseInt(st.nextToken()); //별똥별의 수

        Star[] s = new Star[k];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            s[i] = new Star(x, y);
        }

        int answer = 0;

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                int nx = s[i].x;
                int ny = s[j].y;
                int cnt = 0;

                for(Star ts : s) {
                    if(nx <= ts.x && ts.x <= nx + l &&
                    ny <= ts.y && ts.y <= ny + l)
                        cnt++;
                }

                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(k - answer);
    }

}
