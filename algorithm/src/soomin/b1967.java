package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 1967 트리의 지름
 *  정점 사이 가장 긴 거리를 트리의 지름이라고 한다.
 *  트리가 주어졌을 때 트리를 구하라.
 * */

/* 문제 푸는 방법
 *  (1) 임의점에서 시작하여 제일 먼 노드를 구한다. -> 해당 정점이 트리의 지름의 한 축을 담당하는 정점이다.
 *  (2) 해당 정점에서 제일 먼 노드를 구한다
 *  (3) 둘 사이의 차가 바로 트리의 지름이다.
 * */

public class b1967 {

    static int N;
    // 인접 리스트와 방문 배열
    static ArrayList<int[]>[] lists;
    static boolean [] isVisited;

    // 최대값과 최장정점 저장하는 변수
    static int distantV;
    static int maxLong = 0;
    static int curLong = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1){
            System.out.println(0);
            return;
        }


        // 인접리스트 초기화
        lists = new ArrayList[N+1];


        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        // 인접 리스트 생성
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start   = Integer.parseInt(st.nextToken());
            int end     = Integer.parseInt(st.nextToken());
            int weight  = Integer.parseInt(st.nextToken());

            // index 0 -> 도착 정점, 1 -> 그곳으로 가기 위한 가중치
            lists[start].add(new int[]{end, weight});
            lists[end].add(new int[]{start, weight});
        }


        isVisited = new boolean[N+1];
        dfs(1);
        // 방문 배열 및 최대 거리 체크 초기화
        isVisited = new boolean[N+1];
        maxLong = 0;
        dfs(distantV);

        System.out.println(maxLong);
    }

    public static void dfs(int start){

        isVisited[start] = true;


        int notGoingCnt = 0;

        for (int i = 0; i < lists[start].size(); i++) {
            int destination = lists[start].get(i)[0];
            int weight = lists[start].get(i)[1];

            if(!isVisited[destination]){
                curLong += weight;
                dfs(destination);
                curLong -= weight;
            }
            else{
                notGoingCnt++;
            }
        }


        if(lists[start].size() == notGoingCnt){
            if(maxLong < curLong){
                distantV = start;
                maxLong = curLong;
            }
        }
    }


}
