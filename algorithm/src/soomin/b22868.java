package algorithm.src.soomin;
import java.util.*;
import java.io.*;

public class b22868{

    // 가중치가 없는 양방향 그래프이기 때문에 List의 타입은 Integer여도 충분하다.
    static ArrayList<Integer> [] lists;
    static BitSet bit;

    static int N, M;
    static int home, stopover;
    static int homeTohomeMin = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        //인접 리스트 생성 ----------------------------------------------------------
        lists = new ArrayList [N+1];

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lists[start].add(end);
            lists[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }
        //집과 경유지 받기---------------------------------------------------------------
        st = new StringTokenizer(br.readLine());
        home = Integer.parseInt(st.nextToken());
        stopover = Integer.parseInt(st.nextToken());

        // 1. bfs를 돌리는데, 클래스 이용 (부모가 누군지, 자신의 정점번호는 몇 인지)
        bit = new BitSet(N+1);

        // key: 본인, value: 부모노드
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Node7> aq1 = new ArrayDeque<>();
        Node7 start = new Node7(home, home);
        map.put(home, home);
        aq1.add(start);

        bit.flip(home);

        loopout:
        while(!aq1.isEmpty()) {
            int Qsize = aq1.size();

            for (int i = 0; i < Qsize; i++) {
                Node7 cur = aq1.poll();

                if(cur.me == stopover) {

                    break loopout;
                }

                for (int j = 0; j < lists[cur.me].size(); j++) {
                    if(!bit.get(lists[cur.me].get(j))) {
                        bit.flip(lists[cur.me].get(j));
                        Node7 next = new Node7(cur.me, lists[cur.me].get(j));
                        aq1.add(next);
                        // key: 자신, value: 부모
                        map.put(lists[cur.me].get(j), cur.me );
                    }
                }

            }
            homeTohomeMin++;
        }

//        System.out.println(homeTohomeMin);

        // 2. bfs로 도착하면 도착지 부터 부모노드를 역추적하여 방문 배열 최신화
        bit.clear();

        //next는 자식을 나타냄
        int next = stopover;
        for (int i = 0; i < map.size(); i++) {
            // 자식의 부모를 체크하며 역추적
            bit.set(map.get(next), true);

            // 이제 체크한 부모가 자식이 되어 자신의 부모를 찾음
            next = map.get(next);
        }


        bit.set(home, false);

        // 3. 해당 방문 배열 써서 그냥 bfs
        ArrayDeque<Integer> aq2 = new ArrayDeque<>();
        aq2.add(stopover);

        loopout2:
        while(!aq2.isEmpty()) {
            int Qsize = aq2.size();
            for (int i = 0; i < Qsize; i++) {
                int cur = aq2.poll();

                if(cur == home) {
                    break loopout2;
                }

                for (int j = 0; j < lists[cur].size(); j++) {
                    if(!bit.get(lists[cur].get(j))) {
                        bit.flip(lists[cur].get(j));
                        aq2.add(lists[cur].get(j));
                    }
                }

            }
            homeTohomeMin++;
        }

        System.out.println(homeTohomeMin);
    }
}

class Node7 {
    int parent;
    int me;

    public Node7(int parent, int me) {
        this.parent = parent;
        this.me = me;
    }
}
