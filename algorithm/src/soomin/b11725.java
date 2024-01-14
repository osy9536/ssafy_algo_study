package algorithm.src.soomin;

import java.util.*;
import java.io.*;

public class b11725{

    static ArrayList<Integer> [] lists;



    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        lists = new ArrayList[N+1];

        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            lists[nodeA].add(nodeB);
            lists[nodeB].add(nodeA);
        }

        // 노드 1에서 쭉 bfs -> 직전 노드값 저장하고, 그것이 자신의 부모 노드
        // bfs용 ArrayDeque
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        aq1.add(1);
        // 방문 배열
        BitSet bit = new BitSet(N+1);
        bit.set(1, true);
        // 니 부모가 누구야 Hashmap (key: 자식, value: 부모)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!aq1.isEmpty()){
            int Qsize = aq1.size();
            for (int i = 0; i < Qsize; i++) {
                int cur = aq1.poll();

                for (int j = 0; j < lists[cur].size(); j++) {
                    int next = lists[cur].get(j);
                    if(!bit.get(next)){
                        bit.set(next, true);
                        map.put(next, cur);
                        aq1.add(next);
                    }
                }
            }
        }

        for (int a :
                map.keySet()) {
            if(a == 1) continue;
            System.out.println(map.get(a));
        }

    }

}