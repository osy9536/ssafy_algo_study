package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 1043
 * 거짓말
 * 골드 4
 * https://www.acmicpc.net/problem/1043
 */
public class b1043 {

    static int n; //사람 수
    static int m; //파티 수
    static int knowT; //진실을 아는 사람 수
    static int[] knowTs; //진신을 아는 사람들
    static List<Integer>[] party; //파티 참가 인원
    static List<Integer>[] g; //연결된 사람들

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        knowT = Integer.parseInt(st.nextToken());

        knowTs = new int[knowT];
        for(int i = 0; i < knowT; i++)
            knowTs[i] = Integer.parseInt(st.nextToken());

        party = new ArrayList[m];
        for(int i = 0; i < m; i++) {
            party[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < cnt; j++) {
                int p = Integer.parseInt(st.nextToken());
                party[i].add(p);
            }
        }

        g = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            g[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < party[i].size(); j++) {
                for(int k = j + 1; k < party[i].size(); k++) {
                    g[party[i].get(j)].add(party[i].get(k));
                    g[party[i].get(k)].add(party[i].get(j));
                }
            }
        }

        visited = new boolean[n + 1];

        if(knowTs.length != 0) {
            //진실 알 사람들 확인
            for(int i : knowTs) {
                bfs(i);
            }
        }

        //진실 모르는 사람들의 팀 갯수 정하기
        int answer = 0;
        for(int i = 0; i < m; i++) {
            boolean isAnswer = true;
            for(int j : party[i]) {
                if(visited[j]) {
                    isAnswer = false;
                    break;
                }
            }
            if(isAnswer)
                answer++;
        }

        System.out.println(answer);

    }

    public static void bfs(int cur) {

        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        visited[cur] = true;

        while(!q.isEmpty()) {
            cur = q.poll();

            for(int i : g[cur]) {
                if(visited[i])
                    continue;
                visited[i] = true;
                q.add(i);
            }
        }
    }
}
