package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 18111
 * 마인크래프트
 * 실버 2
 * https://www.acmicpc.net/problem/18111
 */
public class b18111 {

    static int n; //row
    static int m; //column
    static int b; //init block
    static List<Integer> land;
    static int minT; //min time
    static int maxH; //max height;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); //column
        b = Integer.parseInt(st.nextToken()); //init block

        land = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                land.add(cur);
                min = Math.min(min, cur);
                max  = Math.max(max, cur);
            }
        }
 
        minT = Integer.MAX_VALUE;
        maxH = Integer.MIN_VALUE;

        for(int i = min; i <= max; i++)
            flatting(i);

        System.out.println(minT + " " + maxH);
    }

    public static void flatting(int h) {
        int curB = b;
        int tempTime = 0;

        for (int i = 0; i < n * m; i++) {
            if(h < land.get(i)) {
                tempTime += (land.get(i) - h) * 2;
                curB += (land.get(i) - h);
            } else {
                tempTime += ( h - land.get(i));
                curB -= (h - land.get(i));
            }
        }

        if(curB < 0)
            return;

        if(tempTime <= minT) {
            minT = tempTime;
            maxH = h;
        }
    }
}
