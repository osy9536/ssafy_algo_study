package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 2343
 * 기타 레슨
 * 실버 1
 * https://www.acmicpc.net/problem/2343
 */
public class b2343 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // lecture num
        int m = Integer.parseInt(st.nextToken()); // blu-ray num

        int[] lectures = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;
        for(int i = 1; i < n + 1; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, lectures[i]);
            end += lectures[i];
        }

        int curM = 0;
        while(start <= end) {

            int mid = (start + end) / 2;

            curM = countBluRay(lectures, mid);

            if(curM > m)
                start = mid + 1;
            else
                end = mid - 1;

        }

        System.out.println(start);

    }

    public static int countBluRay(int[] lectures, int time) {

        int count = 0;
        int sum = 0;

        for(int i = 1; i < lectures.length; i++) {
            if(sum + lectures[i] > time) {
                sum = 0;
                count++;
            }
            sum += lectures[i];
        }

        if(sum != 0 )
            count++;

        return count;
    }
}
