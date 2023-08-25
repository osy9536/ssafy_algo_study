package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260 {

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static boolean [] flag;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> q1 = new ArrayDeque<>();
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(map.get(from) == null) {

                map.put(from, new ArrayList<>());
                map.get(from).add(to);
                if(map.get(to) == null) {
                    map.put(to, new ArrayList<>());
                    map.get(to).add(from);
                }else {
                    map.get(to).add(from);
                }
            }else {
                map.get(from).add(to);
                if(map.get(to) == null) {
                    map.put(to, new ArrayList<>());
                    map.get(to).add(from);
                }else {
                    map.get(to).add(from);
                }
            }
        }
        flag = new boolean[1001];
        flag[start] = true;
        sb.append(start).append(" ");
        dfs(start);
        System.out.println(sb);


        flag= new boolean[1001];
        flag[start] =true;
        sb.setLength(0);
        q1.add(start);
        bfs(start);



    }

    public static void dfs(int start) {

        if(map.get(start) != null) {
            map.get(start).sort((x1,x2) -> x1 - x2);
        }

        int fullcount = 0;
        for(int i = 0; i < ( map.get(start) == null? 0 : map.get(start).size() ); i++) {
            if(flag[map.get(start).get(i)]) {
                fullcount ++;
                continue;
            }
            else {
                flag[map.get(start).get(i)] = true;
                sb.append(map.get(start).get(i)).append(" ");
                dfs(map.get(start).get(i));
            }
        }

        if(fullcount >= ( map.get(start) == null? 0 : map.get(start).size() )) {
            return;
        }


    }

    public static void bfs(int start) {

        if(map.get(start) != null) {
            map.get(start).sort((x1,x2) -> x1 - x2);
        }

        while(!q1.isEmpty()) {
            int nowSize = q1.size();
            for (int i = 0; i < nowSize; i++) {
                int temp = q1.poll();
                sb.append(temp).append(" ");

                if(map.get(temp) != null) {
                    map.get(temp).sort((x1,x2) -> x1 - x2);
                }


                for (int j = 0; j < (map.get(temp) == null? 0 : map.get(temp).size()); j++) {
                    if(!flag[map.get(temp).get(j)]) {
                        flag[map.get(temp).get(j)] = true;
                        q1.add(map.get(temp).get(j));
                    }
                }
            }
        }
        System.out.println(sb);

    }
}
