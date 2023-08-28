package algorithm.src.soomin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b1753 {

    static int V,E;
    static boolean[] flag ;
    static int [] result;


    //List의 index == from / 배열 0 == to / 배열 1 == weight
    static ArrayList<int []> [] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        flag = new boolean[V+1];
        list = new ArrayList[V+1];

        for (int i = 1; i < V+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new int []{to, weight});
        }

        dijstra(start);
    }

    public static void dijstra(int start) {
        result = new int[V+1];

        // 못 가는 곳을 나타내기 위해 모든 곳을 엄청나게 큰 값으로 초기화
        Arrays.fill(result, Integer.MAX_VALUE);
        // 시작 기점에서 갈 수 있는 경로에 가중치 넣기
        for (int i = 0; i < list[start].size(); i++) {
            // 갈 수 있는 곳이고, 목적지에 지금 있는 값보다, start -> 목적지까지가 더 비용이 싼 경우 초기화 (만약에 1 -> 3으로 가는데 간선이 2개인 경우 대비 )
            if(list[start].get(i)[1] !=0 && result[list[start].get(i)[0]] > list[start].get(i)[1]){
                result[list[start].get(i)[0]] = list[start].get(i)[1];
            }
        }
        flag[start] = true;
        result[start] = 0;

        int nextVertex = findSmall();

        int k = 0;
        while(k < V){
            flag[nextVertex] = true;

            for (int i = 0; i < list[nextVertex].size() ; i++) {

                // 현재 내가 보려는 to 목적지가 방문하지 않았고, 현재 정점 기준으로 갈 수 있는 곳이라면,
                if(!flag[list[nextVertex].get(i)[0]] && list[nextVertex].get(i)[1] != 0){
                    // 원점에서 한번에 to로 가는 것 보다, from -> 현재 정점, 현재 정점 -> to 두 단계 거친 값이 더 작을 경우
                    if(result[list[nextVertex].get(i)[0]] > list[nextVertex].get(i)[1] + result[nextVertex]){
                        result[list[nextVertex].get(i)[0]] = list[nextVertex].get(i)[1] + result[nextVertex];
                    }
                }
            }
            nextVertex = findSmall();
            if(nextVertex == -1) break;
            k++;
        }

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i] == Integer.MAX_VALUE? "INF" : result[i]);
        }

    }

    public static int findSmall() {
        int min = Integer.MAX_VALUE;
        int nextIndex = -1;
        for (int i = 1; i < V+1; i++) {
            if(!flag[i] && min > result[i]){
                min = result[i];
                nextIndex = i;
            }
        }

        //만약에 -1이 나오면 더 이상 방문할 노드가 없다는 뜻
        return nextIndex;
    }
}