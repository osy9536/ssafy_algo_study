package algorithm.src.soomin;

import java.util.*;
import java.io.*;

public class b22870{
    static final int INF = 987654321;
    static int N, M, start, stopOver;
    static ArrayList<int[]> [] lists;

    // key == child, value = parent

    static BitSet bit;
    static long [] minS;
    static long [] minE;
    static long [] minLastE;
    static int ans = 0;
    // 첫번째 값은 노드 번호, 두 번째 값은 시작 정점에서 해당 노드로 가는데 드는 비용


    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
//    	System.setIn(new FileInputStream("C:/Users/JeonSooMin/Downloads/data/add_data_01.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lists = new ArrayList [N+1];
        minS = new long[N+1];
        minE = new long[N+1];
        minLastE = new long[N+1];
        // 초기화 ----------------------------
        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        // 인접리스트에 값 넣기 ------------------
        // 리스트의 index 출발점, 0번째 값 = 도착점, 1번째 값 = 가중치
        // 양방향 바인딩
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new int[] {end, weight});
            lists[end].add(new int[] {start, weight});
        }


        // 출발지와 경유지 받기 -----------------
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        stopOver = Integer.parseInt(st.nextToken());

        Dijstra(start, minS, false);
        Dijstra(stopOver,minE, false);

        //두 다익스트라 배열을 이용하여 최단 경로의 멤버 찾기
        // 출발점이 S이고, 경유지가 E일 때, 현재 S의 인접한 정점 중 무엇이 최단 경로의 멤버인지 체크한다고 보자
        // 이때 minS는 S에서 출발했을 때의 각 정점으로의 최단거리 배열, minE는 E에서 출발했을 때 각 정점으로의 최단거리 배열이다.
        // 정점 N에 대해서 검증할 경우, S까지의 최단 거리(당연히 0이다.) + S -> N까지 가는 가중치 + minE[N](끝점에서 N까지의 최단 거리)
        // == minS[E] (최단경로 값) 이면 N은 최단 거리 멤버 중 하나이다. 시작점과 끝점 양쪽에서 최단 거리로 출발했는데 만나는 정점은 멤버인 것이다.
        // 만약 인접한 정점 M에 대해서도 성립한다면, N과 M 중에서 숫자가 낮은 녀석을 택한다. 여기선 N이라 치자
        // 그 후 S에 N을 대입한다. 그러고 N에 인접한 점이 X,Y,Z이면,
        // minS[N] + N->X 가중치 + minE[X] == minS[E] 이면 X도 최단 경로의 멤버다.
        // 나머지 Y,Z에 대해서도 같은 방식으로 체킹 해준다.
        // 이렇게 하면 사전 식에서 제일 앞 순서의 최단 경로를 구할 수 있다.


        // 유효성 검사
        bit = new BitSet(N+1);
        validTest();


        //경유지 갈 때 거쳤던 사전식 가장 빠른 경로 제끼고 마지막 다익스트라 하기
        Dijstra(stopOver, minLastE, true);

        ans += minS[stopOver];
        ans += minLastE[start];

        System.out.println(ans);



    }

    // Dijstra를 이용한 최단 거리 배열 만드는 함수
    public static void Dijstra(int starter, long [] shortest, boolean isItLast){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        // 다익스트라를 돌리기 위한 초기값 세팅 ----------
        if(!isItLast){
            bit = new BitSet(N+1);
        }

        //배열 초기화 및 초기 갈 수 있는 정점과 그 정점으로 가는 거리 기록-----------
        Arrays.fill(shortest, INF);
//        for (int i = 0; i < lists[starter].size(); i++) {
//            shortest[lists[starter].get(i)[0]] =  lists[starter].get(i)[1];
//            pq.add(new int[] {lists[starter].get(i)[0], lists[starter].get(i)[1]});
//        }

        pq.add(new int[]{starter, 0});
        shortest[starter] = 0;

        // 출발지 -> 경유지로 다익스트라
        while(!pq.isEmpty()) {
            // 값 하나 빼기
            int [] cur = pq.poll();
            int minIdx = cur[0];

            // 이미 방문한 값이면 다시 돌아가기
            if(bit.get(minIdx)) continue;


            //현재 갈 수 있는 최단 경로 정점을 방문 처리 하기
            bit.set(minIdx, true);


            // 현재 최단 경로 배열에 저장된 값과 우회한 비용을 비교했을 때, 우회 비용이 더 작으면 갱신
            for (int j = 0; j < lists[minIdx].size(); j++) {
                //E: minIdx의 인접 정점 중 하나,  V: minIdx -> E로 가는 가중치
                // minD[E] = 현재 기준 start 정점에서 E로 가는 가중치
                int E = lists[minIdx].get(j)[0];
                int V = lists[minIdx].get(j)[1];
                if(shortest[E] > shortest[minIdx] + V) {
                    shortest[E] = shortest[minIdx] + V;
                    pq.add(new int[] {E, (int) (shortest[minIdx] + V)});
                }
            }
//            if(bit.cardinality() == N) {
//                break;
//            }
        }
    }

    public static void validTest(){
        int Spoint = start;

        while(Spoint != stopOver ){
            int candidateE = 200001;
            int edge;
            int value;
            for (int i = 0; i < lists[Spoint].size(); i++) {
                edge = lists[Spoint].get(i)[0];
                value = lists[Spoint].get(i)[1];

                // 유효성 검사
                if(minS[Spoint] + value + minE[edge] == minS[stopOver]){
                    // 만약 기존의 유효성 통과한 정점보다 정점번호가 작다면 갱신
                    if(edge < candidateE){
                        candidateE = edge;
                    }
                }
            }

            if(candidateE == stopOver){
                break;
            }

            // 다음 녀석으로 넘어간다.
            bit.set(candidateE, true);
            Spoint = candidateE;
        }
    }
}