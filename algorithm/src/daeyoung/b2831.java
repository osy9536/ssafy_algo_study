package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 2831
 * 댄스 파티
 * 골드 4
 * https://www.acmicpc.net/problem/2831
 */
public class b2831 {

    static List<Integer> pm; //자기보다 큰 선호하는 남자
    static List<Integer> mm; //자기보다 작은 선호하는 남자
    static List<Integer> pg; //자기보다 큰 선호하는 여자
    static List<Integer> mg; //자기보다 작은 선호하는 여자

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //사람 수

        pm = new ArrayList<>();
        mm = new ArrayList<>();
        pg = new ArrayList<>();
        mg = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num > 0)
                pm.add(num);
            else
                mm.add(-num);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num > 0)
                pg.add(num);
            else
                mg.add(-num);
        }

        Collections.sort(pm);
        Collections.sort(mm);
        Collections.sort(pg);
        Collections.sort(mg);

        int answer = makePair(pm, mg) + makePair(pg, mm);

        System.out.println(answer);
    }

    public static int makePair(List<Integer> p, List<Integer> m) {
        int answer = 0;

        int pIndex = p.size() - 1;
        int mIndex = m.size() - 1;

        while (pIndex >= 0 && mIndex >= 0) {
            if(p.get(pIndex) - m.get(mIndex) < 0 ) {
                pIndex -= 1;
                mIndex -= 1;
                answer++;
            } else {
                pIndex -= 1;
            }
        }

        return answer;
    }
}
