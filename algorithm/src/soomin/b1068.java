package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1068 {

    static int N;
    static ArrayList<Integer>[] lists;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lists = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }

        // ArrayList를 이용해, 트리 구현
        // index가 자식노드, 값이 부모 노드
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                continue;
            }
            lists[parent].add(i);
        }


        // 자식이 있는 원소는 모두 특정 수들로 ArrayList<Integer>가 하나라도 찼을 것이다.
        // 반면 자식이 없는 리프노드는 empty이다.

        // 특정 노드 삭제 시에는 해당 노드의 리프 노드까지 가서 해당 노드에 -1을 넣어준다.
        int deleteNode = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> aq1 = new ArrayDeque<>();

        aq1.add(deleteNode);

        while(!aq1.isEmpty()){
            int Qsize = aq1.size();

            for (int i = 0; i < Qsize; i++) {
                int nowNode = aq1.poll();

                if(lists[nowNode].isEmpty()){
                    lists[nowNode].add(-111);
                }
                else{
                    for (int j = 0; j < lists[nowNode].size(); j++) {
                        aq1.add(lists[nowNode].get(j));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(lists[i].contains(deleteNode) && lists[i].size() > 1){
                break;
            }
            if(lists[i].contains(deleteNode) && lists[i].size() == 1){
                lists[i].clear();
            }
        }


        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(lists[i].isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}
