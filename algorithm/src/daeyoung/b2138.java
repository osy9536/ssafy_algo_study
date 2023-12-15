package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 2138
 * 전구와 스위치
 * 골드 5
 * https://www.acmicpc.net/problem/2138
 */
public class b2138 {

    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String fl = br.readLine();
        String ll = br.readLine();

        int a1 = pushFrist(fl, ll);
        int a2 = pushSecond(fl, ll);

        if(a1 == -1 && a2 == -1)
            System.out.println(-1);
        else if(a1 == -1)
            System.out.println(a2);
        else if(a2 == -1)
            System.out.println(a1);
        else
            System.out.println(Math.min(a1, a2));
    }

    public static int pushFrist(String fl, String ll) {

        int cnt = 0;
        char[] f = fl.toCharArray();
        char[] l = ll.toCharArray();

        if(!compare(f, l)) {
            if(f[0] == '0')
                f[0] = '1';
            else
                f[0] = '0';

            if(f[1] == '0')
                f[1] = '1';
            else
                f[1] = '0';
            cnt++;
        } else {
            return cnt;
        }

        if(!compare(f, l)) {
            for(int i = 1; i < f.length - 1; i++) {

                if(f[i - 1] != l[i - 1]) {
                    if(f[i - 1] == '0')
                        f[i - 1] = '1';
                    else
                        f[i - 1] = '0';

                    if(f[i] == '0')
                        f[i] = '1';
                    else
                        f[i] = '0';

                    if(f[i + 1] == '0')
                        f[i + 1] = '1';
                    else
                        f[i + 1] = '0';
                    cnt++;
                }

//                if(compare(f, l))
//                    return cnt;
            }
        }

        if(f[f.length - 2] != l[l.length - 2]) {
            if(f[f.length - 2] == '0')
                f[f.length - 2] = '1';
            else
                f[f.length - 2] = '0';

            if(f[f.length - 1] == '0')
                f[f.length - 1] = '1';
            else
                f[f.length - 1] = '0';

            cnt++;
        }

        if(compare(f, l))
            return cnt;
        else
            return -1;
    }

    public static int pushSecond(String fl, String ll) {

        int cnt = 0;
        char[] f = fl.toCharArray();
        char[] l = ll.toCharArray();

        if(compare(f, l))
            return cnt;
        else {
            for(int i = 1; i < f.length - 1; i++) {

                if(f[i - 1] != l[i - 1]) {
                    if(f[i - 1] == '0')
                        f[i - 1] = '1';
                    else
                        f[i - 1] = '0';

                    if(f[i] == '0')
                        f[i] = '1';
                    else
                        f[i] = '0';

                    if(f[i + 1] == '0')
                        f[i + 1] = '1';
                    else
                        f[i + 1] = '0';
                    cnt++;
                }

//                if(compare(f, l))
//                    return cnt;
            }
        }

        if(f[f.length - 2] != l[l.length - 2]) {
            if(f[f.length - 2] == '0')
                f[f.length - 2] = '1';
            else
                f[f.length - 2] = '0';

            if(f[f.length - 1] == '0')
                f[f.length - 1] = '1';
            else
                f[f.length - 1] = '0';

            cnt++;
        }

        if(compare(f, l))
            return cnt;
        else
            return -1;
    }

    public static boolean compare(char[] f, char[] l) {
        for(int i = 0; i < f.length; i++) {
            if(f[i] != l[i])
                return false;
        }

        return true;
    }
}
