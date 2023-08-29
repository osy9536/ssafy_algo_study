package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b13023 {

    // 정점과 간선
    static int V,E;
    static ArrayList<Integer>[]  lists;
    static boolean [] flag;

    // 입력 받은 그래프에서 갈 수 있는 최대 깊이를 계속 갱신
    static int valid = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        lists = new ArrayList[V];


        for(int i = 0; i < V; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            lists[from].add(to);
            lists[to].add(from);
        }

        for(int i = 0; i< V; i++) {
            flag = new boolean [V];
            flag[i]=true;
            dfs(i,1);

            if(valid == 1) {
                break;
            }
        }

        System.out.println(valid);

    }

    // 깊이 우선 탐색으로 쭉 가고, 깊이가 5가 되면은 탈출해서 해당 그래프가 깊이 5까지 갈 수 있다고 알림.
    // 해당 깊이에서 더 이상 갈 수 없으면 return으로 돌아오고 다른 깊이를 탐색
    public static void dfs(int index, int deepth) {

        //기저조건 -> 만약 깊이가 5가 되면 1 반환하고 탈출
        if(deepth == 5) {
            valid =1;
            return;
        }





        for(int i = 0; i < lists[index].size(); i++) {
            if(flag[lists[index].get(i)]) continue;

            flag[lists[index].get(i)]= true;
            dfs(lists[index].get(i), deepth+1);
            flag[lists[index].get(i)] = false;
        }

    }
}
