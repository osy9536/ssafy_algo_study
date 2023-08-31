package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b17471 {
    static int N;
    static int cnt = 0;
    static int min = Integer.MAX_VALUE;

    static int [] citizenCount;
    static ArrayList<Integer>[] vilieges;
    static boolean [] flag;
    static boolean []isVisited;

    static ArrayList<Integer> blueTeam = new ArrayList<>();
    static ArrayList<Integer> redTeam = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        vilieges = new ArrayList [N+1];
        citizenCount = new int[N+1];
        flag = new boolean[N+1];


        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인구수 초기화
        for (int i = 1; i <= N; i++) {
            citizenCount[i] = Integer.parseInt(st.nextToken());
        }

        // 인접리스트 초기화
        for(int i = 1; i <= N ; i++) {
            vilieges[i] = new ArrayList<>();
        }

        // 인접리스트 완성
        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for (int j = 1; j <=num ; j++) {
                int temp = Integer.parseInt(st.nextToken());
                vilieges[i].add(temp);

            }
        }

        makingTeam(1);

        System.out.println(min == Integer.MAX_VALUE? -1 : min);
    }

    // 부분집합 사용 powerSet 구하기
    public static void makingTeam(int deepth) {

        if(deepth > N) {

            // 찬 반 팀 나눠서 담기
            for (int i = 1; i <= N; i++) {
                if(flag[i]) blueTeam.add(i);
                else redTeam.add(i);
            }

            if(redTeam.size()==0 || blueTeam.size() == 0) {
                redTeam.clear();
                blueTeam.clear();
                return;
            }


            // 유효성 검사
            for (int i = 1; i < blueTeam.size(); i++) {
                if(!blueBfs(blueTeam.get(0), blueTeam.get(i))) {
                    redTeam.clear();
                    blueTeam.clear();
                    return;
                }
            }
            for (int i = 1; i < redTeam.size(); i++) {
                if(!redBfs(redTeam.get(0), redTeam.get(i))) {
                    redTeam.clear();
                    blueTeam.clear();
                    return;
                }
            }

            // 유효성 검사를 통과했다면 이제 계산
            int blueSum = 0;
            int redSum = 0;

            for (int i = 0; i < blueTeam.size(); i++) {
                blueSum += citizenCount[blueTeam.get(i)];
            }

            for (int i = 0; i < redTeam.size(); i++) {
                redSum += citizenCount[redTeam.get(i)];
            }

            // 최소값 갱신
            min = Math.min(min, Math.abs(redSum - blueSum));

            redTeam.clear();
            blueTeam.clear();
            return;
        }


        flag[deepth] = true;
        makingTeam(deepth+1);
        flag[deepth] = false;
        makingTeam(deepth+1);

    }

    private static boolean redBfs(int start, int end) {
        isVisited = new boolean[N+1];
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        q1.offer(start);
        isVisited[start] = true;

        while(!q1.isEmpty()) {
            int current = q1.poll();

            if(current == end) {
                return true;
            }

            for (int i = 0; i < vilieges[current].size(); i++) {

                // flag가 블루팀이고, 아직 큐에서 방문하지 않았다면,
                if(!flag[vilieges[current].get(i)] && !isVisited[vilieges[current].get(i)]){
                    isVisited[vilieges[current].get(i)] = true;
                    q1.add(vilieges[current].get(i));
                }
            }
        }
        return false;
    }

    public static boolean blueBfs (int start, int end) {
        isVisited = new boolean[N+1];
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        q1.offer(start);
        isVisited[start] = true;

        while(!q1.isEmpty()) {
            int current = q1.poll();

            if(current == end) {
                return true;
            }

            for (int i = 0; i < vilieges[current].size(); i++) {

                // flag가 블루팀이고, 아직 큐에서 방문하지 않았다면,
                if(flag[vilieges[current].get(i)] && !isVisited[vilieges[current].get(i)]){
                    isVisited[vilieges[current].get(i)] = true;
                    q1.add(vilieges[current].get(i));
                }
            }
        }

        return false;
    }
}
