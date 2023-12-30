package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 1461
 * 도서관
 * 골드 4
 * https://www.acmicpc.net/submit/1461
 */
public class b1461 {

    static int n; //책의 수
    static int m; //한번에 들수 있는 책의 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> plusLocation = new ArrayList<>(); //+ 책 위치
        List<Integer> minusLocaton = new ArrayList<>(); //- 책 위치

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur > 0)
                plusLocation.add(cur);
            else
                minusLocaton.add(cur * -1);
        }

        int answer = 0;

        if(plusLocation.size() != 0) {
            Collections.sort(plusLocation, Collections.reverseOrder());
            answer += calDistance(plusLocation);
        }

        if(minusLocaton.size() != 0) {
            Collections.sort(minusLocaton, Collections.reverseOrder());
            answer += calDistance(minusLocaton);
        }
        if(plusLocation.size() == 0)
            answer -= minusLocaton.get(0);
        else if(minusLocaton.size() == 0)
            answer -= plusLocation.get(0);
        else if(plusLocation.get(0) > minusLocaton.get(0))
            answer -= plusLocation.get(0);
        else
            answer -= minusLocaton.get(0);

        System.out.println(answer);
    }

    public static int calDistance(List<Integer> location) {
        int distance = 0;

        for(int i = 0; i < location.size(); i += m){
            distance += location.get(i) * 2;
        }

        return distance;
    }
}
